package modelo;

import vista.Recursos;

public class MocoRojo extends Enemigo{
public MocoRojo(){
	super(Recursos.mocoRojo);
	setAncho(50);
	setAlto(50);
	animExplosion = Recursos.animExplosion;
}
}
