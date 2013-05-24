package modelo.personajes;

import modelo.Constantes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import vista.Recursos;

public class JefeRajoy extends Enemigo{
public JefeRajoy() {
	super(Recursos.jefeRajoy);
	setAncho(100);
	setAlto(100);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animJefeRajoyDerecha;
	animIzquierda = Recursos.animJefeRajoyIzquierda;
	puntos=100;
	posMovimiento=0;
	resetMovimientos();
	setVy(movimientos[1]);
	setVx(movimientos[0]);
	setVida(30);
	canal="Enemigo";
	registrarseEnElMediador(canal);
	}

@Override
public boolean disparo(){
	return false;
}
public void resetMovimientos(){
	movimientos = Constantes.movimientoRajoy.clone();
}


}
