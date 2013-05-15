package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Libelula extends Enemigo{

	public Libelula() {
		super(Recursos.libelula1);
		setAncho(75);
		setAlto(75);
		setVida(1);
		animExplosion = Recursos.animExplosion;
		animDerecha = Recursos.animLibelulaDerecha;
		animIzquierda = Recursos.animLibelulaIzquierda;
		puntos=10;
		tipoMovimiento="aleatorio";
		posMovimiento=0;
		movimientos = new float[]{
				200,-100,800,0,
				-10,0,730,0,
				-500,-100,0,0,
				10,0,80,0,
				400,50,500,0,
				200,-100,800,0,
				-10,0,730,0,
				-500,-100,0,0,
				10,0,80,0,
				400,50,500,0,
				200,-100,800,0,
				-10,0,730,0,
				-500,-100,0,0,
				10,0,80,0,
				400,50,500,0,
				-50,-300,0,0
				
		};
		setVy(movimientos[1]);
		setVx(movimientos[0]);
	}

}
