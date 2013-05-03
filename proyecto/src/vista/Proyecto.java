package vista;

import modelo.Logica;
import modelo.Reloj;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


import controlador.EventosTeclado;

public class Proyecto implements ApplicationListener {
	
	private Logica logica;
	private int fps;
	private Reloj reloj;
	
	@Override
	public void create() {	
		logica=new Logica();
		Gdx.input.setInputProcessor(new EventosTeclado(logica));
		logica.inicializarMapa();
		reloj = new Reloj();
		
	}
	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {	
		reloj.actualizar(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//logica.iA();
		logica.actualizar(Gdx.graphics.getDeltaTime());
		logica.dibujar();
		logica.colision();
		if(reloj.getAcumulado()>1){
		  reloj.reset();
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
