package vista;

import java.util.ArrayList;

import modelo.Bala;
import modelo.Enemigo;
import modelo.Entidad;
import modelo.EntidadDinamica;
import modelo.FabricaEntidadesDinamicas;
import modelo.InterfazFabrica;
import modelo.Logica;
import modelo.Nave;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

import controlador.EventosTeclado;

public class Proyecto implements ApplicationListener {
	private SpriteBatch batch;
	private Texture texture;
	public TextureRegion textura;
	private Logica logica;
	private int fps;
	private float acumulador=0;
	@Override
	public void create() {		
		logica=new Logica(this);
	/*	float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		*/
		Gdx.input.setInputProcessor(new EventosTeclado(logica));
		InterfazFabrica fabrica = new FabricaEntidadesDinamicas();
		
		batch = new SpriteBatch();
		Rectangle rec = new Rectangle(0,0,10,10);
		Rectangle rec2 = new Rectangle(9,9,10,10);
		texture = new Texture(Gdx.files.internal("data/enemy.png"));
		textura = new TextureRegion(texture);
		logica.crearNave(textura);
		logica.crearEntidades("Enemigo",new float[]{0,400,50,50,1,-0.5f},textura);		
		logica.crearEntidades("Enemigo",new float[]{0,500,50,50,0.2f,-1.5f},textura);
		logica.crearEntidades("Enemigo",new float[]{0,300,50,50,1,-0.5f},textura);		
		logica.crearEntidades("Enemigo",new float[]{150,500,50,50,0.2f,-0.5f},textura);
		logica.crearEntidades("Enemigo",new float[]{150,600,50,50,0,-3f},textura);
		logica.crearEntidades("Enemigo",new float[]{400,600,50,50,0,0.5f},textura);
		logica.crearEntidades("Enemigo",new float[]{350,500,50,50,0.1f,2f},textura);
		logica.crearEntidades("Enemigo",new float[]{700,600,50,50,-0.5f,-1f},textura);
		logica.crearEntidades("Enemigo",new float[]{600,600,50,50,-0.5f,0.5f},textura);
		logica.crearEntidades("Enemigo",new float[]{500,500,50,50,-1f,-0.5f},textura);
		
		
		//Entidad personaje = fabrica.crearEntidad("Personaje",new float[]{270,70,200,50,4,4},textura);
		//array.add(personaje);
		System.out.println("Contiene?");
	}
	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {	
		acumulador+=Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		logica.dibujar();
		logica.iA();
		logica.update();
		logica.colision();
		if(acumulador>1){
		  acumulador=0;
			System.out.println("FPS: "+fps);
			fps=0;
		}else fps++;
			
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
