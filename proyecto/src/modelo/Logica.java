package modelo;

import java.util.ArrayList;

import modelo.niveles.Nivel1;

import vista.Proyecto;
import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Logica {
	private static Proyecto proyecto;
	InterfazFabricaEntidad fabrica = new FabricaEntidadesDinamicas();
	private ArrayList<Entidad> array = new ArrayList<Entidad>();
	private SpriteBatch batch;
	Nave nave;
	Nivel1 nivel1;
	private float acumulador=0;
	private int fila=0;

public Logica(Proyecto proy) {
	proyecto=proy;
	batch = new SpriteBatch();
	nivel1=new Nivel1();
}
public void crearNave(int i,int j){
	nave=(Nave) fabrica.crearEntidad("Nave",new float[]{Gdx.graphics.getWidth()/3*i,Gdx.graphics.getHeight()/3*j,0,0});
	array.add(nave);
}
public void crearBala(){
	array.add(fabrica.crearEntidad("Bala",new float[]{nave.getX()+nave.getAncho()/2-10,nave.getY()+nave.getAlto(),0,4}));
}
public void crearEntidades(String _entidad, float[] parametros){
	if(!_entidad.equals(""))
	array.add(fabrica.crearEntidad(_entidad, new float[]{Gdx.graphics.getWidth()/3*parametros[0],Gdx.graphics.getHeight()/3*parametros[1],parametros[2],parametros[3]}));
	}
public void inicializarMapa(){
	int i=nivel1.getFilaActual();
	int h=0;
	ArrayList<String> filas=nivel1.getFila(4);
	
	for(String unaFila : filas){
		System.out.println("La i vale:"+i+" Y la h vale : "+h);
		if(unaFila.equals("Nave")) {
			crearNave(h,i);
		}else{
		crearEntidades(unaFila, new float[]{h,i,0,-0.2f});
		}
		if(h<4)h++;
		if(h==3){i++;
		h=0;}
	}
}
public void actualizar(float time){
	
	for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(time);
	acumulador+=time;
	if(acumulador>6){
		  acumulador=0;
		  ArrayList<String> filas=nivel1.getFila(1);
		  if(!filas.isEmpty()){
			    for(int j=0;j<filas.size();j++)
			  crearEntidades(filas.get(j), new float[]{800/3*j,600/3*3,0,-0.2f});
			fila++;
		  }	
	}
}
public void iA(){
	double random;
	for(int i=0;i<array.size();i++){
		if(array.get(i) instanceof Enemigo){
		random=Math.random()*50;
		if(random>2 && random<2.55){
			crearEntidades("BalaEnemigo",new float[]{array.get(i).getX()+array.get(i).getAncho()/2,array.get(i).getY(),20,20,0,-4});
		}
		}
	}
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
			}else if(array.get(r) instanceof Nave && array.get(i) instanceof Enemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Enemigo && array.get(i) instanceof Nave){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof BalaEnemigo && array.get(i) instanceof Nave){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Nave && array.get(i) instanceof BalaEnemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}
	}
		
		if(array.get(r) instanceof Bala || array.get(r) instanceof Enemigo)
			if(array.get(r).getY()<0 || array.get(r).getY()>Gdx.graphics.getHeight()+50 )
				eliminar[r]=array.get(r);}
		//System.out.println(array.size());
	for(Entidad entidad : eliminar){
		if(entidad!=null)array.remove(entidad);
	}
}
public void dibujar(){
	batch.begin();
	batch.draw(Recursos.fondo, 0, 
			0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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

