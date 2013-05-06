package modelo.personajes;

import vista.Recursos;

public class MocoRojo extends Enemigo{
public MocoRojo(){
	super(Recursos.mocoRojo);
	setAncho(50);
	setAlto(50);
	animExplosion = Recursos.animExplosion;
	puntos=30;
	setVy(-0.5f);
	setVx(0);
}
}
