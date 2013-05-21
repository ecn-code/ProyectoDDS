package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.decorador.ExtraVelocidad;
import modelo.decorador.ExtraVida;
import modelo.personajes.BalaEnemigo;
import modelo.personajes.BolaVida;
import modelo.personajes.Enemigo;
import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.Fondo;
import modelo.personajes.JefeRajoy;
import modelo.personajes.Nave;


import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ColeccionEntidades {
	
	private LinkedList<EntidadDinamica>  array;
	private EntidadDinamica nave;
	private FabricaEntidadesDinamicas fabrica;
	private int puntos=0;
	private EntidadDinamica jefeRajoy;
	private Logica logica;
	
	public ColeccionEntidades(Logica _logica){ 
		array = new LinkedList<EntidadDinamica>() ;
		fabrica = new FabricaEntidadesDinamicas();
		logica = _logica;
		}
	
	public void crearEntidad(String _tipo,float[] parametros){
		if(_tipo.equals("Escorpion")){
			array.add(fabrica.crearEntidad("BolaVida", new float[]{Constantes.columnaCalculada*(parametros[0]),Constantes.filaCalculada*parametros[1]}));
		}
		if(_tipo!=""){
			EntidadDinamica a = fabrica.crearEntidad(_tipo, new float[]{Constantes.columnaCalculada*(parametros[0]),Constantes.filaCalculada*parametros[1]});
			logica.agrega(a);
			array.add(a);
		
		}
		}
	
	public void crearBala(){
		if(nave==null) buscarNave();
		array.add(fabrica.crearEntidad("Bala",new float[]{nave.getX()+nave.getAncho()/2-10,nave.getY()+nave.getAlto(),0,4}));
	}
	
	public void actualizar(float time,float acumulado){
		/*
		ArrayList<EntidadDinamica> balasEnemigo = new ArrayList<EntidadDinamica>();
		for(Entidad entidad : array){
			if(entidad instanceof Enemigo)ejecutarMovimiento((Enemigo)entidad);
			if(entidad.disparo()) balasEnemigo.add(fabrica.crearEntidad("BalaEnemigo",new float[]{entidad.getX()+entidad.getAncho()/2-10,entidad.getY()}));
			((EntidadDinamica) entidad).actualizar(time);	
		}
		for(EntidadDinamica entidad : balasEnemigo) array.add(entidad);
		*/
	}
	
	private float tipoMovimiento(String tipoMovimiento,float time) {
		if(tipoMovimiento.equals(""))
		return -999f;
		else return (float) Math.cos(time);
	}
	
	private void ejecutarMovimiento(Enemigo _enemigo) {
		if(_enemigo.movimientos!=null && 
				_enemigo.posMovimiento<_enemigo.movimientos.length){
		if(_enemigo.movimientos[_enemigo.posMovimiento+2]<=0 &&
				_enemigo.movimientos[_enemigo.posMovimiento+3]<=0){
			_enemigo.posMovimiento=_enemigo.posMovimiento+4;
			if(_enemigo.posMovimiento>=_enemigo.movimientos.length){
				_enemigo.posMovimiento=0;
			_enemigo.resetMovimientos();
			}
		_enemigo.setVx(_enemigo.movimientos[_enemigo.posMovimiento]);
		_enemigo.setVy(_enemigo.movimientos[_enemigo.posMovimiento+1]);
		}
		}
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
		logica.suprime(nave);
		nave=new ExtraVelocidad(nave);
		logica.suprime(nave);
		nave=new ExtraVida(nave);
		logica.agrega(nave);
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
		int ghu=-1;
		if(nave==null) buscarNave();
	for(int r=0;array.size()-1>r;r++) {
		for(int i=r+1;array.size()>i;i++){
			if(array.get(r).colision(array.get(i))&& array.get(i).getExplosiona()==false && array.get(r).getExplosiona()==false  ){
				System.out.println("i: "+i+" vida="+array.get(r).getVida());
				
				if(array.get(r) instanceof BolaVida){
					array.remove(r);
					ghu=i;
				}else if(array.get(i) instanceof BolaVida){
					array.remove(i);
					ghu=r;
				}else{
				array.get(r).setVida(array.get(r).getVida()-1);
				array.get(i).setVida(array.get(i).getVida()-1);
				if(array.get(r).getVida()==0){
					array.get(r).getEstado().colisionar();
				}
				if(array.get(i).getVida()==0){
					array.get(i).getEstado().colisionar();
					
				}	
				}
			}
		}
		if(!(array.get(r) instanceof Fondo))
		if(array.get(r).getY()<-95 || array.get(r).getY()>Gdx.graphics.getHeight()+50 ){
			array.get(r).setEliminar(true);
			array.get(r).setPuntos(0);
		}
	}
	if(ghu>0){
		array.remove(nave);
		nave=new ExtraVida(nave);
		array.add(1,nave);
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

	public float getVidaNave() {
		// TODO Auto-generated method stub
		if(nave!=null)
		return nave.getVida();
		else return 0;
	}
	
}
