package modelo.personajes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import vista.Recursos;

public class JefeRajoy extends Enemigo{
public JefeRajoy() {
	super(Recursos.jefeRajoy);
	setAncho(50);
	setAlto(50);
	animExplosion = Recursos.animExplosion;
	puntos=30;
	}

}
