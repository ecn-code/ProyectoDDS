package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class BolaVida extends EntidadDinamica{
public BolaVida(){
	super(Recursos.bolaVida);
	setAncho(35);
	setAlto(35);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animBolaVidaDerecha;
	animIzquierda = Recursos.animBolaVidaIzquierda;
	puntos=30;
	setVy(-Constantes.velocidadBolaVida);
	setVx(0);
	setVida(2);
	tipoMovimiento = "aleatorio";
}

@Override
public boolean colision(Entidad _entidad) {
	// TODO Auto-generated method stub
	return false;
}
}
