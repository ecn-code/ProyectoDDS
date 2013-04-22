package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Nave extends EntidadDinamica {
public Nave(float x,float y,float ancho,float alto, float vx, float vy,TextureRegion textura){
	super(x,y,ancho,alto,vx,vy,textura);
}
}