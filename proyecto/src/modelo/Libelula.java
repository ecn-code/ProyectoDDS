package modelo;

import vista.Recursos;

public class Libelula extends Enemigo{

	public Libelula() {
		super(Recursos.libelula);
		setAncho(50);
		setAlto(50);
		animExplosion = Recursos.animExplosion;
	}

}
