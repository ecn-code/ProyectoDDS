package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Fondo extends EntidadDinamica {

	public Fondo() {
		super(Recursos.nube1);
		setAncho(Gdx.graphics.getWidth());
		setAlto(10000);
		setVy(-Constantes.velocidadFondo);
		setVx(0);
		canal="Fondo";
		registrarseEnElMediador(canal);
		canalesDeColision=new String[]{""};

	}

	public Fondo(TextureRegion _texturaNormal) {
		super(_texturaNormal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}



}
