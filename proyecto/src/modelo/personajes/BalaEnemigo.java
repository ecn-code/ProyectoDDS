package modelo.personajes;

import vista.Recursos;


public class BalaEnemigo extends Enemigo{
	public BalaEnemigo(){
		super(Recursos.bala);
	setAncho(20);
	setAlto(20);
	vx=0;
	vy=-4;
	animExplosion = Recursos.animExplosion;
	}
}
