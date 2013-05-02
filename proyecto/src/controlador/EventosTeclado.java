package controlador;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
		instanciarComando("controlador.DOWN_"+keycode);
		return false;
	
	}
	
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		instanciarComando("controlador.UP_"+keycode);
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
	private void instanciarComando(String _clase){
		try {
			Class<?> clase = Class.forName(_clase);
			Object object;
		
				object = clase.getDeclaredConstructor(Logica.class).newInstance(logica);
				logica.getInvoker().setComando((Comando) object);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
