package modelo;

import vista.Proyecto;

import com.badlogic.gdx.Input;

public class Logica {
	private static Proyecto proyecto;
public Logica(Proyecto proy) {
	proyecto=proy;
}
public void teclaPulsada(int tecla){
	if(tecla==Input.Keys.RIGHT){
		proyecto.moverPersonajeX(2);
	}else if(tecla==Input.Keys.LEFT){
		proyecto.moverPersonajeX(-2);
	}else if(tecla==Input.Keys.UP){
		proyecto.moverPersonajeY(2);
	}else if(tecla==Input.Keys.DOWN){
		proyecto.moverPersonajeY(-2);
	}
}
public void teclaSoltada(int tecla){
	if(tecla==Input.Keys.RIGHT){
		proyecto.moverPersonajeX(0);
	}else if(tecla==Input.Keys.LEFT){
		proyecto.moverPersonajeX(0);
	}else if(tecla==Input.Keys.UP){
		proyecto.moverPersonajeY(0);
	}else if(tecla==Input.Keys.DOWN){
		proyecto.moverPersonajeY(0);
	}
}
}
