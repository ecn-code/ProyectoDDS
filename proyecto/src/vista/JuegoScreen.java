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
		game = _game;
		logica=new Logica();
		Gdx.input.setInputProcessor(new EventosTeclado(logica));
		logica.inicializarMapa();
		reloj = new Reloj();
	}

	@Override
	public void render(float delta) {
if(logica.gameOver()) game.setScreen(new GameOver());
if(logica.gameWin()) game.setScreen(new GameWin());
	reloj.actualizar(delta);
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
			//logica.iA();
			logica.actualizar(delta);
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
