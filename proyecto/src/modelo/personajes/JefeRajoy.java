package modelo.personajes;

import modelo.Constantes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import vista.Recursos;

public class JefeRajoy extends Enemigo{
public JefeRajoy() {
	super(Recursos.jefeRajoy);
	setAncho(50);
	setAlto(50);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animJefeRajoyDerecha;
	animIzquierda = Recursos.animJefeRajoyIzquierda;
	puntos=30;
	posMovimiento=0;
	movimientos = new float[]{
			0,-20,0,100,
			-100,-100,100,50,
			100,100,50,100,
			0,-100,0,20,
			100,0,50,0
	};
	setVy(movimientos[1]);
	setVx(movimientos[0]);
	setVida(30);
	}
@Override
public boolean disparo(){
	return Math.random()*10<1;
}

}
