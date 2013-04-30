package modelo;

import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Bala extends EntidadDinamica {
	public Bala(){
		super(Recursos.bala);
	setAncho(20);
	setAlto(20);
	vx=0;
	vy=4;
	}
	public Bala (float x,float y,float ancho,float alto, float vx, float vy,AtlasRegion textura){
		super(x,y,ancho,alto,vx,vy,textura);
		texturaNormal=Recursos.bala;
	}
}