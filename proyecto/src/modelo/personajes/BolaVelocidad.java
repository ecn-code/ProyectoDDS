package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class BolaVelocidad extends EntidadDinamica{
	public BolaVelocidad(){
	super(Recursos.bolaVelocidad);
	setAncho(35);
	setAlto(35);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animBolaVelocidadDerecha;
	animIzquierda = Recursos.animBolaVelocidadIzquierda;
	puntos=30;
	setVy(-Constantes.velocidadBolaVelocidad);
	setVx(0);
	setVida(2);
	tipoMovimiento = "aleatorio";
	}
	public boolean colision(Entidad _entidad) {
		// TODO Auto-generated method stub
		return false;
	}
}
