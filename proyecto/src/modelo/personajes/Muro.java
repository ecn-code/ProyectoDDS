package modelo.personajes;

import objectPool.MensajesPool;
import modelo.estrategia.Mensaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Muro extends EntidadDinamica {

	public Muro() {
		super(null);
reset();
	}
	
	public void actualiza(SpriteBatch batch){	
		Mensaje mensaje = MensajesPool.damePoolMensajes().adquirir();
		mensaje.setDescripcion(this.getSuperficie());
		mensaje.setAsunto("ComprobarFueraPantalla");
		mensaje.setCanalEmisor(canal);
		for(String _canal : canalesDeColision)
		mediador.enviar(_canal, mensaje);
	}
	
public void actualiza(float time){

	}

@Override
public void reset() {
	setAlto(1);
	setVx(0);
	setVy(0);
	setAncho(Gdx.graphics.getWidth()*100);
	canalesDeColision = new String[]{"BalaEnemigo","Enemigo","BalaPersonaje"};
	canal = "";
	System.out.println(getClass().getSimpleName());
}

}
