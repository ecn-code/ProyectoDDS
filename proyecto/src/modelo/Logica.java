package modelo;

import java.util.ArrayList;

import sun.font.TrueTypeFont;
import vista.JuegoScreen;
import vista.Recursos;
import modelo.decorador.ExtraVelocidad;
import modelo.decorador.ExtraVida;
import modelo.estrategia.IEstrategia;
import modelo.niveles.Nivel1;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.IFabrica;
import modelo.personajes.Nave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import controlador.Invoker;


public class Logica extends Sujeto implements IColega{
	Invoker invoker;
	IFabrica fabrica = new FabricaEntidadesDinamicas();
	
	private static SpriteBatch batch;
	Nivel1 nivel1;
	private Reloj reloj;
	private Reloj relojBalas;
	private int cambiosVelocidad;
	private Marcador marcador;
	private ShapeRenderer rectangulo;
	private Mediador mediador;
	private EntidadDinamica nave;
	BitmapFont font;

public Logica() {
	marcador = new Marcador();
	marcador.reset();
	batch = new SpriteBatch();
	nivel1=new Nivel1();
	reloj=new Reloj();
	relojBalas=new Reloj();
	invoker=new Invoker(null);
	cambiosVelocidad=0;
	rectangulo = new ShapeRenderer();
	mediador = Mediador.getMediador();
	mediador.reset();
	mediador.registrarse("Logica", this);
	crearEntidad("Muro", new Vector2(0,-50));
	crearEntidad("Muro", new Vector2(0,Gdx.graphics.getHeight()+150));
	font = new BitmapFont();
	font.scale(3);
}

public static SpriteBatch dameBatch(){
	return batch;
}

public void crearBala(){
	if(relojBalas.getAcumulado() - relojBalas.getTiempoGuardado() > 0.19f){
	crearBala(nave);
	Recursos.sonidoDisparo.play(0.3f);
	relojBalas.setTiempoGuardado(relojBalas.getAcumulado());
	}
}

public void inicializarMapa(){
	crearEntidad("Fondo", new Vector2(0,0));
	int numeroFila=nivel1.getFilaActual();
	int numeroColumna=0;
	ArrayList<String> filas=nivel1.getFila(Constantes.filasPantalla+1);
	
	for(String unaFila : filas){
		Vector2 parametros = new Vector2(numeroColumna*Constantes.columnaCalculada,numeroFila*Constantes.filaCalculada);
		crearEntidad(unaFila, parametros);
		if(numeroColumna<Constantes.ColumnasPantalla)numeroColumna++;
		if(numeroColumna==Constantes.ColumnasPantalla){
		numeroFila++;
		numeroColumna=0;}
	}
	
	nave = mediador.getNave();
	
}

public void decorarVelocidad(){
	suprime(nave);
	mediador.eliminarColega("Nave", nave);
	nave = new ExtraVelocidad(nave);
	mediador.registrarse("Nave", nave);
	agrega( nave);
}

public Invoker getInvoker(){
	return invoker;
}

public boolean gameOver(){
	return nave.getVida()<=0;
}

public void actualizar(float time){
	
	if(invoker.hayComando()){
		invoker.ejecutar();
	}
	//coleccionEntidades.actualizar(time,reloj.getAcumulado());
	relojBalas.actualizar(time);
	reloj.actualizar(time);
	if(reloj.getAcumulado()>Constantes.tiempoRefrescoMapa){
		  reloj.reset();
		  ArrayList<String> filas=nivel1.getFila(1);
		  if(!filas.isEmpty()){
			    for(int numeroColumna=0;numeroColumna<filas.size();numeroColumna++){
			    	Vector2 parametros = new Vector2(numeroColumna,Constantes.filasPantalla);
			    	parametros.x *= Constantes.columnaCalculada;
					parametros.y *= Constantes.filaCalculada;
					crearEntidad(filas.get(numeroColumna), parametros);
			  
			    }
		  }	
	}
	this.notifica(time);
}


public void dibujar(){
	batch.begin();
	font.setColor(0.0f, 1.0f, 1.0f, 1.0f);
	
	 
	//coleccionEntidades.dibujar(batch);
	this.notifica(batch);
	int desplazamientoCifrasMarcador = 120;
	batch.draw(Recursos.panelSuperior, 0, 
			Gdx.graphics.getHeight()-50, Gdx.graphics.getWidth(),50 );
	for(TextureRegion texture : marcador.getTexturas()){
		batch.draw(texture, marcador.getPosX()+desplazamientoCifrasMarcador, marcador.getPosY (),
				marcador.getAncho(),marcador.getAlto());
	desplazamientoCifrasMarcador-=20;	
	}
	font.draw(batch, JuegoScreen.fps()+" FPS", 600, 600);
	batch.end();
	rectangulo.begin(ShapeType.Filled);
	 rectangulo.rect(147f, 552f, 106, 26, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
   rectangulo.rect(150f, 555f, nave.getVida()*5, 20, Color.RED, Color.GREEN, Color.GREEN, Color.RED);
    rectangulo.end();
}


public void moverNaveX(float vx){
	if(vx==0) cambiosVelocidad--;
	else cambiosVelocidad++;
	
	if(cambiosVelocidad==0 || vx!=0)
	nave.setVx(vx);
}
public void moverNaveY(float vy){
	nave.setVy(vy);
}

public boolean gameWin() {
	return false;
}


@Override
public void recibir(IEstrategia estrategia) {
	estrategia.comportamiento();
}

public void puntua(int puntos) {
	marcador.sumar(puntos);
}

public void crearEntidad(String _tipo,Vector2 parametros){
	if(_tipo!=""){
		EntidadDinamica a = (EntidadDinamica) fabrica.crearProducto(_tipo, parametros);
		agrega(a);
	}
	}
public void crearBalaEnemigo(Vector2 parametros) {
	crearEntidad("BalaEnemigo",parametros);
}
public void crearBala(EntidadDinamica _nave){
	Vector2 parametros = new Vector2();
	parametros.x = _nave.getX()+nave.getAncho()/2-10;
	parametros.y = _nave.getY()+nave.getAlto();
	crearEntidad("Bala",parametros);
}

public void decorarVida() {
	suprime(nave);
	mediador.eliminarColega("Nave", nave);
	nave = new ExtraVida(nave);
	mediador.registrarse("Nave", nave);
	agrega(nave);
}

public int getPuntos() {
	// TODO Auto-generated method stub
	return marcador.getPuntosTotal();
}
}

