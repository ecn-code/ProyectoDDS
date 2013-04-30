package vista;

import java.util.ArrayList;

import modelo.Bala;
import modelo.Enemigo;
import modelo.Entidad;
import modelo.EntidadDinamica;
import modelo.FabricaEntidadesDinamicas;
import modelo.InterfazFabricaEntidad;
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
	private Logica logica;
	private int fps;
	private float acumulador=0;
	@Override
	public void create() {		
		logica=new Logica(this);
		Gdx.input.setInputProcessor(new EventosTeclado(logica));
		InterfazFabricaEntidad fabrica = new FabricaEntidadesDinamicas();
		logica.inicializarMapa();
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
		logica.actualizar(Gdx.graphics.getDeltaTime());
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
