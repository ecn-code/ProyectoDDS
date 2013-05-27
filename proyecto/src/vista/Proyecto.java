package vista;


import modelo.Logica;
import modelo.Reloj;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


import controlador.EventosTeclado;

public class Proyecto extends Game {

	public void create() {	
		setScreen(new IntroJuego(this));
		
	  }
}