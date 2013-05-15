package modelo;

import java.util.ArrayList;

import vista.Recursos;
import modelo.niveles.Nivel1;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.InterfazFabricaEntidad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import controlador.Invoker;


public class Logica {
	Invoker invoker;
	InterfazFabricaEntidad fabrica = new FabricaEntidadesDinamicas();
	
	private SpriteBatch batch;
	Nivel1 nivel1;
	private Reloj reloj;
	private int cambiosVelocidad;
	private ColeccionEntidades coleccionEntidades;
	private Marcador marcador;

public Logica() {
	marcador = new Marcador();
	marcador.reset();
	coleccionEntidades =  new ColeccionEntidades();
	batch = new SpriteBatch();
	nivel1=new Nivel1();
	reloj=new Reloj();
	invoker=new Invoker(null);
	cambiosVelocidad=0;
	System.out.println("Logica");
}

public void crearBala(){
	coleccionEntidades.crearBala();
	Recursos.sonidoDisparo.play(0.3f);
	
}

public void inicializarMapa(){
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,0,0,400f});
	/*coleccionEntidades.crearEntidad("Fondo", new float[]{0,5,0,-0.5f});
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,4,0,-0.5f});
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,3,0,-0.5f});
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,2,0,-0.5f});
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,1,0,-0.5f});
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,0,0,-0.5f});*/
	int numeroFila=nivel1.getFilaActual();
	int numeroColumna=0;
	ArrayList<String> filas=nivel1.getFila(Constantes.filasPantalla+1);
	
	for(String unaFila : filas){
		coleccionEntidades.crearEntidad(unaFila, new float[]{numeroColumna,numeroFila,0,-1f});
		if(numeroColumna<Constantes.ColumnasPantalla)numeroColumna++;
		if(numeroColumna==Constantes.ColumnasPantalla){
		numeroFila++;
		numeroColumna=0;}
	}
}
public Invoker getInvoker(){
	return invoker;
}

public boolean gameOver(){
	return coleccionEntidades.gameOver();
}

public void actualizar(float time){
	if(invoker.hayComando()){
		invoker.ejecutar();
	}
	marcador.sumar(coleccionEntidades.getPuntos());
	coleccionEntidades.resetPuntos();
	coleccionEntidades.actualizar(time,reloj.getAcumulado());

	reloj.actualizar(time);
	if(reloj.getAcumulado()>Constantes.tiempoRefrescoMapa){
		//coleccionEntidades.crearEntidad("Fondo",0, new float[]{0,6,0,-0.5f});
		  reloj.reset();
		  ArrayList<String> filas=nivel1.getFila(1);
		  if(!filas.isEmpty()){
			    for(int numeroColumna=0;numeroColumna<filas.size();numeroColumna++)
			  coleccionEntidades.crearEntidad(filas.get(numeroColumna), new float[]{numeroColumna,
				  Constantes.filasPantalla,0,-3f});
		  }	
	}
}
/*
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
*/
/*
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
*/
public void colision(){
coleccionEntidades.colision();
}

public void dibujar(){
	batch.begin();
	coleccionEntidades.dibujar(batch);
	int desplazamientoCifrasMarcador = 120;
	batch.draw(Recursos.panelSuperior, 0, 
			Gdx.graphics.getHeight()-50, Gdx.graphics.getWidth(),50 );
	for(TextureRegion texture : marcador.getTexturas()){
		batch.draw(texture, marcador.getPosX()+desplazamientoCifrasMarcador, marcador.getPosY (),
				marcador.getAncho(),marcador.getAlto());
	desplazamientoCifrasMarcador-=20;	
	}
	batch.end();
}

public void moverNaveX(float vx){
	if(vx==0) cambiosVelocidad--;
	else cambiosVelocidad++;
	
	if(cambiosVelocidad==0 || vx!=0)
	coleccionEntidades.moverNaveX(vx);
}
public void moverNaveY(float vy){
	coleccionEntidades.moverNaveY(vy);
}

public boolean gameWin() {
	return coleccionEntidades.gameWin();
}
}

