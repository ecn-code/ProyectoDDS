package modelo;

import java.util.ArrayList;

import vista.Recursos;
import modelo.niveles.Nivel1;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.InterfazFabricaEntidad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import controlador.Invoker;


public class Logica extends Sujeto{
	Invoker invoker;
	InterfazFabricaEntidad fabrica = new FabricaEntidadesDinamicas();
	
	private SpriteBatch batch;
	Nivel1 nivel1;
	private Reloj reloj;
	private Reloj relojBalas;
	private int cambiosVelocidad;
	private ColeccionEntidades coleccionEntidades;
	private Marcador marcador;
	private ShapeRenderer rectangulo;

public Logica() {
	marcador = new Marcador();
	marcador.reset();
	coleccionEntidades =  new ColeccionEntidades(this);
	batch = new SpriteBatch();
	nivel1=new Nivel1();
	reloj=new Reloj();
	relojBalas=new Reloj();
	invoker=new Invoker(null);
	cambiosVelocidad=0;
	rectangulo = new ShapeRenderer();
}

public void crearBala(){
	if(relojBalas.getAcumulado() - relojBalas.getTiempoGuardado() > 0.19f){
	coleccionEntidades.crearBala();
	Recursos.sonidoDisparo.play(0.3f);
	relojBalas.setTiempoGuardado(relojBalas.getAcumulado());
	}
}

public void inicializarMapa(){
	coleccionEntidades.crearEntidad("Fondo", new float[]{0,0,0,400f});
	int numeroFila=nivel1.getFilaActual();
	int numeroColumna=0;
	ArrayList<String> filas=nivel1.getFila(Constantes.filasPantalla+1);
	
	for(String unaFila : filas){
		coleccionEntidades.crearEntidad(unaFila, new float[]{numeroColumna,numeroFila});
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
	System.out.println("----L"+time);
	if(invoker.hayComando()){
		invoker.ejecutar();
	}
	marcador.sumar(coleccionEntidades.getPuntos());
	coleccionEntidades.resetPuntos();
	coleccionEntidades.actualizar(time,reloj.getAcumulado());
	relojBalas.actualizar(time);
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
	this.notifica();
}
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
	rectangulo.begin(ShapeType.Filled);
	 rectangulo.rect(147f, 552f, 106, 26, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
    rectangulo.rect(150f, 555f, coleccionEntidades.getVidaNave()*5, 20, Color.RED, Color.GREEN, Color.GREEN, Color.RED);
    rectangulo.end();
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

