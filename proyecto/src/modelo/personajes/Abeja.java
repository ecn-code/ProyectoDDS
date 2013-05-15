package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Abeja extends Enemigo{
public Abeja(){
	super(Recursos.abeja1);
	setAncho(32);
	setAlto(30);
	animExplosion = Recursos.animExplosion;
	puntos=30;
	setVy(-Constantes.velocidadAveja);
	setVx(0.1f);
	setVida(1);
	animDerecha = Recursos.animAbeja;
	animIzquierda = Recursos.animAbeja;
	puntos = 10;
	tipoMovimiento = "aleatorio";
}
}
