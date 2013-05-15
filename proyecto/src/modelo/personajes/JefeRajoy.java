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
	puntos=30;
	setVy(-Constantes.velocidadJefeRajoy);
	setVida(10);
	}
@Override
public boolean disparo(){
	return Math.random()*10<1;
}

}
