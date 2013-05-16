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
			300,-50,800,0,
			-10,0,730,0,
			-500,-50,0,0,
			10,0,60,0,
			200,0,500,0,	
			-10,0,450,0,
			-300,-50,0,0,
			10,100,70,0
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
