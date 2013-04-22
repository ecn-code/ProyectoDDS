package modelo;

import java.util.ArrayList;

import vista.Proyecto;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Logica {
	private static Proyecto proyecto;
	InterfazFabrica fabrica = new FabricaEntidadesDinamicas();
	private ArrayList<Entidad> array = new ArrayList<Entidad>();
	private SpriteBatch batch;
	EntidadDinamica nave;
public Logica(Proyecto proy) {
	proyecto=proy;
	batch=new SpriteBatch();
}
public void crearNave(float[] parametros,TextureRegion textura){
	nave=(EntidadDinamica) fabrica.crearEntidad("Nave", parametros,textura);
	array.add(nave);
}
public void crearEntidades(String _entidad, float[] parametros,TextureRegion textura){
	array.add(fabrica.crearEntidad(_entidad, parametros,textura));
	}
public void update(){
	for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(5f);
}
public void colision(){
	for(int r=0;array.size()>r;r++) 
		for(int i=0;array.size()>i;i++)
		if(array.get(i)!=array.get(r))
		if(array.get(r).colision(array.get(i).getSuperficie()))
			System.out.println("Si");
		else
			System.out.println("No");
}
public void dibujar(){
	batch.begin();
	for(Entidad entidad : array)
	batch.draw(entidad.getTextura(), entidad.getX(), 
			entidad.getY(), entidad.getAncho(), entidad.getAlto());
	batch.end();
}

public void moverNaveX(float vx){
	nave.setVx(vx);
}
public void moverNaveY(float vy){
	nave.setVy(vy);
}
}

