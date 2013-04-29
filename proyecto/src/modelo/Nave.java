package modelo;

import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Nave extends EntidadDinamica {
 



public Nave(float x,float y,float ancho,float alto, float vx, float vy,AtlasRegion textura){
	super(x,y,ancho,alto,vx,vy,textura);
	Recursos.girar();
	animIzquierda = Recursos.animNaveIzquierda;
	animDerecha = Recursos.animNaveDerecha;
	texturaNormal = Recursos.naveNormal;
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