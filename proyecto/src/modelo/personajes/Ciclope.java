package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Ciclope extends Enemigo{
public Ciclope(){
	super(Recursos.ciclope1);
	reset();
}
public void resetMovimientos(){
	movimientos = Constantes.movimientoCiclope.clone();
}
public void reset(){
	setAncho(35);
	setAlto(35);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animCiclopeDerecha;
	animIzquierda = Recursos.animCiclopeIzquierda;
	puntos=50;
	setVy(-Constantes.velocidadCiclope);
	setVx(0);
	setVida(6);
	tipoMovimiento = "aleatorio";
	posMovimiento=0; 
	resetMovimientos();
	setVy(movimientos[1]);
	setVx(movimientos[0]);
	canal="Enemigo";
	registrarseEnElMediador(canal);
}
}
