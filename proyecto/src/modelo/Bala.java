package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bala extends EntidadDinamica {
	public Bala (float x,float y,float ancho,float alto, float vx, float vy,TextureRegion textura){
		super(x,y,ancho,alto,vx,vy,textura);
	}
}