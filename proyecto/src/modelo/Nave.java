package modelo;

import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Nave extends EntidadDinamica {
	
public Nave(){
	super(Recursos.naveNormal);
	Recursos.girar();
	animIzquierda = Recursos.animNaveIzquierda;
	animDerecha = Recursos.animNaveDerecha;
}
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