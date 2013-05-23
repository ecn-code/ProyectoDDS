package modelo.personajes;


import objectPool.MensajesPool;
import modelo.estrategia.Mensaje;
import vista.Recursos;

import com.badlogic.gdx.Gdx;

public class Nave extends EntidadDinamica{
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
	canal="Nave";
	registrarseEnElMediador(canal);
	canalesDeColision=new String[]{"Enemigo","BalaEnemigo","Extra"};
}
public void actualizar(float time) {
		// TODO Auto-generated method stub 
	if(!(superficie.getX()+getVx()*time>0 && superficie.getX()+superficie.getWidth()+getVx()*time<Gdx.graphics.getWidth()))
		setVx(0);
	if(!(getY()+getVy()*time>0 && superficie.getY()+superficie.getHeight()+getVy()*time<Gdx.graphics.getHeight()))
		setVy(0);
		
super.actualizar(time);

Mensaje mensaje = MensajesPool.damePoolMensajes().adquirir();
mensaje.setDescripcion(this.getSuperficie());
mensaje.setAsunto("ComprobarColision");
mensaje.setCanalEmisor(canal);
for(String _canal : canalesDeColision)
mediador.enviar(_canal, mensaje);

	}
@Override
public void reset() {
	// TODO Auto-generated method stub
	
}


}