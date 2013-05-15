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
<<<<<<< HEAD
	setVida(2);
=======
	tipoMovimiento = "aleatorio";
>>>>>>> 43d4f9d5d5f44054d5a5ce723ff1040386a4d3e4
}
}
