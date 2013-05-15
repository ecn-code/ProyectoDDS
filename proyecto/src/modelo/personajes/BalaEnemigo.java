package modelo.personajes;

import vista.Recursos;


public class BalaEnemigo extends Enemigo{
	public BalaEnemigo(){
		super(Recursos.bala);
	setAncho(20);
	setAlto(20);
	setVx(0);
	setVy(-4);
	setVida(1);
	animExplosion = Recursos.animExplosion;
	}
}
