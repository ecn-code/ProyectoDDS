package modelo.personajes;

import modelo.Constantes;
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
	setVy(-Constantes.velocidadMocoRojo);
	setVx(0);
	setVida(2);
	tipoMovimiento = "aleatorio";
}
}
