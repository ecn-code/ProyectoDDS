package modelo.personajes;

import vista.Recursos;

public class Libelula extends Enemigo{

	public Libelula() {
		super(Recursos.libelula);
		setAncho(50);
		setAlto(50);
		setVy(-2);
		setVx(0);
		animExplosion = Recursos.animExplosion;
		animDerecha = Recursos.animLibelulaDerecha;
		animIzquierda = Recursos.animLibelulaIzquierda;
		puntos=10;
		tipoMovimiento="aleatorio";
	}

}
