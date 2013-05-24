package vista;

import modelo.Logica;
import modelo.Reloj;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

import controlador.EventosTeclado;

public class JuegoScreen implements Screen {
Game game;
private Logica logica;
private int fps;
private Reloj reloj;
	public JuegoScreen(Game _game) {
		System.out.println(logica);
		game = _game;
		logica=new Logica();
		Gdx.input.setInputProcessor(new EventosTeclado(logica));
		logica.inicializarMapa();
		reloj = new Reloj();
		
	}

	@Override
	public void render(float delta) {

	reloj.actualizar(delta);
	if(reloj.getAcumulado()-reloj.getTiempoGuardado()>0.010){
		reloj.setTiempoGuardado(reloj.getAcumulado());
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			if(logica.gameOver() || logica.gameOver() && !logica.gameWin()) game.setScreen(new GameOver(game));
			if(!logica.gameOver() && logica.gameWin()) game.setScreen(new GameWin());
			logica.actualizar(delta);
			logica.dibujar();
			logica.colision();
			fps++;
	}
			if(reloj.getAcumulado()>1){				
			  reloj.reset();
			  reloj.setTiempoGuardado(reloj.getAcumulado());
			  System.out.println("FPS: "+fps);
				fps=0;}
			
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
