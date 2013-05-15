package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;


public class BalaEnemigo extends Enemigo{
	public BalaEnemigo(){
		super(Recursos.balaEnemiga);
	setAncho(10);
	setAlto(10);
	setVx(0);
	setVy(-Constantes.velocidadBalaEnemigo);
	setVida(1);
	animExplosion = Recursos.animExplosion;
	}
	@Override
	public boolean disparo(){
		return false;
	}
}
