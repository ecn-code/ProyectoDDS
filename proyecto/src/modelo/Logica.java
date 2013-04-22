package modelo;

import java.util.ArrayList;

import vista.Proyecto;

import com.badlogic.gdx.Gdx;
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
public void crearNave(TextureRegion textura){
	nave=(EntidadDinamica) fabrica.crearEntidad("Nave", new float[]{0,0 ,50,50,0,0},textura);
	array.add(nave);
}
public void crearBala(){
	crearEntidades("Bala",new float[]{nave.getX()+nave.getAncho()/2,nave.getY()+nave.getAlto(),5,10,0,4},proyecto.textura);
}
public void crearEntidades(String _entidad, float[] parametros,TextureRegion textura){
	array.add(fabrica.crearEntidad(_entidad, parametros,textura));
	}
public void update(){
	for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(5f);
}
public void colision(){
	Entidad[] eliminar= new Entidad[array.size()];
	for(int r=0;array.size()>r;r++) {
		for(int i=0;array.size()>i;i++){
			
		if(array.get(i)!=array.get(r))
		if(array.get(r).colision(array.get(i).getSuperficie()))
			if(array.get(i) instanceof Bala && array.get(r) instanceof Enemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Bala && array.get(i) instanceof Enemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}
	}
		
		if(array.get(r) instanceof Bala || array.get(r) instanceof Enemigo)
			if(array.get(r).getY()<0 || array.get(r).getY()>Gdx.graphics.getHeight()+50)
				eliminar[r]=array.get(r);}
		//System.out.println(array.size());
	for(Entidad entidad : eliminar){
		if(entidad!=null)array.remove(entidad);
	}
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

