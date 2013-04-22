package modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Nave extends EntidadDinamica {
public Nave(float x,float y,float ancho,float alto, float vx, float vy,TextureRegion textura){
	super(x,y,ancho,alto,vx,vy,textura);
}

@Override
	public void actualizar(float time) {
		// TODO Auto-generated method stub
	if(!(superficie.getX()+vx>0 && superficie.getX()+superficie.getWidth()+vx<Gdx.graphics.getWidth()))
		vx=0;
	if(!(superficie.getY()+vy>0 && superficie.getY()+superficie.getHeight()+vy<Gdx.graphics.getHeight()))
		vy=0;
		super.actualizar(time);
	}
}