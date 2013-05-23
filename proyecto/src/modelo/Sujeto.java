package modelo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import modelo.personajes.EntidadDinamica;

public abstract class Sujeto {
	
	protected Collection<Observador> observadores;

	public Sujeto() {
		observadores = new CopyOnWriteArrayList<Observador>();
	}
	
	public void agrega(Observador observador){
		observadores.add(observador);
	}
	
	public void suprime(Observador observador){
		observadores.remove(observador);
	}
	public void notifica(SpriteBatch batch){
		for(Observador observador : observadores)
			observador.actualiza(batch);
	}
	public void notifica(float time){
		for(Observador observador : observadores)
			observador.actualiza(time);
	}
}
