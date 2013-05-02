package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.Nave;


import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ColeccionEntidades {
	
	private LinkedList<EntidadDinamica>  array;
	private EntidadDinamica nave;
	private FabricaEntidadesDinamicas fabrica;
	private int puntos=0;
	
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
	
	public void actualizar(float time){
		for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(time);
	}
	
	public void dibujar(SpriteBatch batch){
		batch.draw(Recursos.fondo, 0, 
				0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for(Entidad entidad : array)
		batch.draw(entidad.getTextura(), entidad.getX(), 
				entidad.getY(), entidad.getAncho(), entidad.getAlto());
	}
	
	public void buscarNave(){
		for(Entidad entidad : array) {
			if(entidad instanceof Nave){
				nave = (EntidadDinamica) entidad;
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
			if(array.get(r).colision(array.get(i))){
				array.get(r).getEstado().colisionar();
				array.get(i).getEstado().colisionar();
				
			}
		}
		if(array.get(r).getY()<-50 || array.get(r).getY()>Gdx.graphics.getHeight()+50 )
			array.get(r).setEliminar(true);
	}	
for (Iterator<EntidadDinamica> iter = array.iterator(); iter.hasNext();) {
	Entidad entidad = iter.next();
if(entidad.isEliminar()){ iter.remove();puntos+=10;}
}


}
   public void resetPuntos(){
	   puntos = 0;
   }
	public int getPuntos() {
		return puntos;
	}}
