package modelo.personajes;

import modelo.Constantes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import vista.Recursos;

public class JefeRajoy extends Enemigo{
public JefeRajoy() {
	super(Recursos.jefeRajoy);
	reset();
	}
@Override
public boolean disparo(){
	return false;
}
public void resetMovimientos(){
	movimientos = Constantes.movimientoRajoy.clone();
}
@Override
public void reset() {
	setAncho(50);
	setAlto(50);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animJefeRajoyDerecha;
	animIzquierda = Recursos.animJefeRajoyIzquierda;
	puntos=30;
	posMovimiento=0;
	resetMovimientos();
	setVy(movimientos[1]);
	setVx(movimientos[0]);
	setVida(30);
	canal="Enemigo";
	registrarseEnElMediador(canal);
}


}
