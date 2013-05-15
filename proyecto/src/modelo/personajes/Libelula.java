package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Libelula extends Enemigo{

	public Libelula() {
		super(Recursos.libelula1);
		setAncho(75);
		setAlto(75);
		setVy(-Constantes.velocidadLibelula);
		setVx(0);
		setVida(1);
		animExplosion = Recursos.animExplosion;
		animDerecha = Recursos.animLibelulaDerecha;
		animIzquierda = Recursos.animLibelulaIzquierda;
		puntos=10;
		tipoMovimiento="aleatorio";
	}

}
