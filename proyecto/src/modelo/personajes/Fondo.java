package modelo.personajes;

import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Fondo extends EntidadDinamica {

	public Fondo() {
		super(Recursos.nube1);
		setAncho(Gdx.graphics.getWidth());
		setAlto(100);
		setVy(-0.2f);
		setVx(0);
	}

	public Fondo(TextureRegion _texturaNormal) {
		super(_texturaNormal);
		// TODO Auto-generated constructor stub
	}

	public Fondo(float _x, float _y, float _ancho, float _alto, float _vx,
			float _vy, TextureRegion _textura) {
		super(_x, _y, _ancho, _alto, _vx, _vy, _textura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean colision(Entidad _entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
