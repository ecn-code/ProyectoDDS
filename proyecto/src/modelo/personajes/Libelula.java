package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Libelula extends Enemigo{

	public Libelula() {
		super(Recursos.libelula1);
		reset();
	}

	@Override
	public boolean disparo(){
		return Math.random()*20<1;
	}

	@Override
	public void reset() {
		setAncho(75);
		setAlto(75);
		setVida(1);
		animExplosion = Recursos.animExplosion;
		animDerecha = Recursos.animLibelulaDerecha;
		animIzquierda = Recursos.animLibelulaIzquierda;
		puntos=10;
		tipoMovimiento="aleatorio";
		posMovimiento=0;
		resetMovimientos();
		setVy(movimientos[1]);
		setVx(movimientos[0]);
		canal = "Enemigo";
		registrarseEnElMediador(canal);
		canalesDeColision=new String[]{"Amigo"};
	}

}
