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
	setVida(20);
}
public void actualizar(float time) {
	System.out.println("----N"+time);
		// TODO Auto-generated method stub
<<<<<<< HEAD
	
=======
>>>>>>> 39bf7754e3b5f02dadef4e7f3d24db07134456bf
	if(!(superficie.getX()+getVx()*time>0 && superficie.getX()+superficie.getWidth()+getVx()*time<Gdx.graphics.getWidth()))
		setVx(0);
	if(!(getY()+getVy()*time>0 && superficie.getY()+superficie.getHeight()+getVy()*time<Gdx.graphics.getHeight()))
		setVy(0);
		
super.actualizar(time);
	}
}