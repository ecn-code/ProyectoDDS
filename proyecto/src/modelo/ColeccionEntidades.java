package modelo;

import java.util.ArrayList;

import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ColeccionEntidades {
	
	private ArrayList<Entidad> array;
	private EntidadDinamica nave;
	private FabricaEntidadesDinamicas fabrica;
	
	public ColeccionEntidades(){ 
		array = new ArrayList<Entidad>();
		fabrica = new FabricaEntidadesDinamicas();
		}
	
	public void crearEntidad(String _tipo,float[] parametros){
		if(_tipo!="")
			array.add(fabrica.crearEntidad(_tipo, new float[]{Gdx.graphics.getWidth()/3*parametros[0],Gdx.graphics.getHeight()/3*parametros[1],parametros[2],parametros[3]}));
	}
	
	public void crearBala(){
		if(nave==null) buscarNave();
		array.add(fabrica.crearEntidad("Bala",new float[]{nave.getX()+nave.getAncho()/2-10,nave.getY()+nave.getAlto(),0,4}));
	}
	
	public void actualizar(float time){
		for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(time);
	}
	
	public void dibujar(SpriteBatch batch){
		batch.begin();
		batch.draw(Recursos.fondo, 0, 
				0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for(Entidad entidad : array)
		batch.draw(entidad.getTextura(), entidad.getX(), 
				entidad.getY(), entidad.getAncho(), entidad.getAlto());
		batch.end();
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
}
