package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;


public class BalaEnemigo extends Enemigo{
	public BalaEnemigo(){
		super(Recursos.bala);
	setAncho(20);
	setAlto(20);
	setVx(0);
	setVy(-Constantes.velocidadBalaEnemigo);
	setVida(1);
	animExplosion = Recursos.animExplosion;
	}
}
