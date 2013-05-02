package controlador;

import modelo.Logica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class EventosTeclado implements InputProcessor {
Logica logica;
public EventosTeclado(Logica _logica){
	logica = _logica;
}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Input.Keys.RIGHT)
			logica.moverNaveX(3);
		if(keycode==Input.Keys.LEFT)
			logica.moverNaveX(-3);
		if(keycode==Input.Keys.UP)
			logica.moverNaveY(3);
		if(keycode==Input.Keys.DOWN)
			logica.moverNaveY(-3);
		if(keycode==Input.Keys.SPACE)
			logica.crearBala();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Input.Keys.RIGHT)
			logica.moverNaveX(0);
		if(keycode==Input.Keys.LEFT)
			logica.moverNaveX(0);
		if(keycode==Input.Keys.UP)
			logica.moverNaveY(0);
		if(keycode==Input.Keys.DOWN)
			logica.moverNaveY(0);
		
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX<Gdx.graphics.getWidth()/3)
			logica.moverNaveX(-3);
		else if(screenX>Gdx.graphics.getWidth()/3 && screenX<(Gdx.graphics.getWidth()/3)*2)
			logica.crearBala();
		else logica.moverNaveX(3);
		return false;
	
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(screenX<Gdx.graphics.getWidth()/3)
			logica.moverNaveX(0);
		else
			logica.moverNaveX(0);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
