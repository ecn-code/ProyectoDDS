package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.decorador.ExtraVelocidad;
import modelo.decorador.ExtraVida;
import modelo.personajes.BalaEnemigo;
import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.JefeRajoy;
import modelo.personajes.Nave;


import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ColeccionEntidades {
	
	private LinkedList<EntidadDinamica>  array;
	private EntidadDinamica nave;
	private FabricaEntidadesDinamicas fabrica;
	private int puntos=0;
	private EntidadDinamica jefeRajoy;
	
	public ColeccionEntidades(){ 
		array = new LinkedList<EntidadDinamica>() ;
		fabrica = new FabricaEntidadesDinamicas();
		}
	
	public void crearEntidad(String _tipo,float[] parametros){
		if(_tipo!="")
			array.add(fabrica.crearEntidad(_tipo, new float[]{Constantes.columnaCalculada*(parametros[0]),Constantes.filaCalculada*parametros[1],parametros[2],parametros[3]}));
	}
	
	public void crearBala(){
		if(nave==null) buscarNave();
		array.add(fabrica.crearEntidad("Bala",new float[]{nave.getX()+nave.getAncho()/2-10,nave.getY()+nave.getAlto(),0,4}));
	}
	
	public void actualizar(float time,float acumulado){
		ArrayList<EntidadDinamica> balasEnemigo = new ArrayList<EntidadDinamica>();
		for(Entidad entidad : array){
			final float vx = tipoMovimiento(((EntidadDinamica) entidad).getTipoMovimiento(),acumulado);
			if(vx>-900) ((EntidadDinamica) entidad).setVx(vx);
			if(entidad.disparo()) balasEnemigo.add(fabrica.crearEntidad("BalaEnemigo",new float[]{entidad.getX()+entidad.getAncho()/2-10,entidad.getY()}));
			((EntidadDinamica) entidad).actualizar(time);	
		}
		for(EntidadDinamica entidad : balasEnemigo) array.add(entidad);
	}
	
	private float tipoMovimiento(String tipoMovimiento,float time) {
		if(tipoMovimiento.equals(""))
		return -999f;
		else return (float) Math.cos(time);
	}

	public void dibujar(SpriteBatch batch){
		
		for(Entidad entidad : array)
		batch.draw(entidad.getTextura(), entidad.getX(), 
				entidad.getY(), entidad.getAncho(), entidad.getAlto());
	}
	
	public void buscarNave(){
		int i;
		for(i=0;i<array.size();i++) {
			if(array.get(i) instanceof Nave){
				nave = (EntidadDinamica) array.get(i);
				break;
			}
		}
		array.remove(i);
		nave=new ExtraVelocidad(nave);
		nave=new ExtraVida(nave);
		array.add(i,nave);
	}
	
	public void buscarJefeRajoy(){
		for(Entidad entidad : array) {
			if(entidad instanceof JefeRajoy){
				jefeRajoy = (EntidadDinamica) entidad;
				break;
			}
		}
	}
	
	public void moverNaveX(float vx){
		if(nave==null) buscarNave();
		nave.setVx(vx);
	}
	public void moverNaveY(float vy){
		if(nave==null) buscarNave();
		nave.setVy(vy);
	}
	public void colision(){
	for(int r=0;array.size()-1>r;r++) {
		for(int i=r+1;array.size()>i;i++){
			if(array.get(r).colision(array.get(i))&& array.get(i).getExplosiona()==false && array.get(r).getExplosiona()==false  ){
				System.out.println("i: "+i+" vida="+array.get(r).getVida());
				array.get(r).setVida(array.get(r).getVida()-1);
				array.get(i).setVida(array.get(i).getVida()-1);
				//System.out.println("vida"+array.get(r).getVida());
				//System.out.println("vida"+array.get(i).getVida());
				if(array.get(r).getVida()==0){
					array.get(r).getEstado().colisionar();
					System.out.println("entra");
				}
				if(array.get(i).getVida()==0){
					array.get(i).getEstado().colisionar();
					
				}
				
			}
		}
		if(array.get(r).getY()<-95 || array.get(r).getY()>Gdx.graphics.getHeight()+50 ){
			array.get(r).setEliminar(true);
			array.get(r).setPuntos(0);
		}
	}	
for (Iterator<EntidadDinamica> iter = array.iterator(); iter.hasNext();) {
	Entidad entidad = iter.next();
if(entidad.isEliminar()){ iter.remove();puntos+=entidad.getPuntos();}
}


}
   public void resetPuntos(){
	   puntos = 0;
   }
	public int getPuntos() {
		return puntos;
	}

	public void crearEntidad(String _tipo, int i, float[] parametros) {
		if(_tipo!="")
			array.add(i,fabrica.crearEntidad(_tipo, new float[]{Constantes.columnaCalculada*(parametros[0]),Constantes.filaCalculada*parametros[1]}));
	
	}

	public boolean gameOver() {
		if(nave!=null)
		return nave.isEliminar();
		else return false;
	}
	
	public boolean gameWin() {
		if(jefeRajoy!=null)
		return jefeRajoy.isEliminar();
		else {
			buscarJefeRajoy();
			return false;}
	}
	
}
