  package modelo.personajes;


import vista.Recursos;

import com.badlogic.gdx.Gdx;

public class Nave extends Amigo{
	
public Nave(){
	super(Recursos.naveNormal);
	animIzquierda = Recursos.animNaveIzquierda;
	animDerecha = Recursos.animNaveDerecha;
	animExplosion = Recursos.animExplosion;
	setAncho(50);
	setAlto(50);
	setVx(0);
	setVy(0);
	setVida(1);
}
public void actualizar(float time) {
		// TODO Auto-generated method stub
	if(!(superficie.getX()+getVx()>0 && superficie.getX()+superficie.getWidth()+getVx()<Gdx.graphics.getWidth()))
		setVx(0);
	if(!(getY()>0 && superficie.getY()+superficie.getHeight()+getVy()<Gdx.graphics.getHeight()))
		setVy(0);
super.actualizar(time);
	}



}