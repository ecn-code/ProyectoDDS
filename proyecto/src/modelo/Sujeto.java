package modelo;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Sujeto {
	
	protected Collection<Observador> observadores;

	public Sujeto() {
		observadores = new LinkedList<Observador>();
	}
	
	public void agrega(Observador observador){
		observadores.add(observador);
	}
	
	public void suprime(Observador observador){
		observadores.remove(observador);
	}
	public void notifica(){
		for(Observador observador : observadores)
			observador.actualiza();
	}
}
