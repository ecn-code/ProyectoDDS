package modelo;

import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class BalaEnemigo extends EntidadDinamica{
	public BalaEnemigo (float x,float y,float ancho,float alto, float vx, float vy,AtlasRegion textura){
		super(x,y,ancho,alto,vx,vy,textura);
		texturaNormal=Recursos.bala;
	}
}
