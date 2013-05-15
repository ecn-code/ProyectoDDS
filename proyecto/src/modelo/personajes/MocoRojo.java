package modelo.personajes;

import vista.Recursos;

public class MocoRojo extends Enemigo{
public MocoRojo(){
	super(Recursos.mocoRojo1);
	setAncho(35);
	setAlto(35);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animMocoRojoDerecha;
	animIzquierda = Recursos.animMocoRojoIzquiera;
	puntos=30;
	setVy(-0.5f);
	setVx(0);
	tipoMovimiento = "aleatorio";
}
}
