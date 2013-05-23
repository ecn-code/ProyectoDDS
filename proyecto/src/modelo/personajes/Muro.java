package modelo.personajes;

import modelo.estrategia.Mensaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Muro extends EntidadDinamica {

	public Muro() {
		super(null);
		setAlto(1);
		setAncho(Gdx.graphics.getWidth());
		canalesDeColision = new String[]{"BalaEnemigo","Enemigo"};
		canal = "";
	}
	
	public void actualiza(SpriteBatch batch){
		
		Mensaje mensaje = new Mensaje();
		mensaje.setDescripcion(this.getSuperficie());
		mensaje.setAsunto("ComprobarFueraPantalla");
		mensaje.setCanalEmisor(canal);
		for(String _canal : canalesDeColision)
		mediador.enviar(_canal, mensaje);
	}
	
public void actualiza(float time){

	}

}
