package modelo.personajes;

import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Bala extends Amigo {
	public Bala(){
		super(Recursos.bala);
	setAncho(20);
	setAlto(20);
	vx=0;
	vy=4;
	animExplosion = Recursos.animExplosion;
	}
	
}