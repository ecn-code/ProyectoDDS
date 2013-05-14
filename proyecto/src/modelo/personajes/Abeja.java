package modelo.personajes;

import vista.Recursos;

public class Abeja extends Enemigo{
public Abeja(){
	super(Recursos.abeja1);
	setAncho(32);
	setAlto(30);
	animExplosion = Recursos.animExplosion;
	puntos=30;
	setVy(-0.5f);
	setVx(0);
	animDerecha = Recursos.animAbeja;
	animIzquierda = Recursos.animAbeja;
	puntos = 10;
	tipoMovimiento = "aleatorio";
}
}
