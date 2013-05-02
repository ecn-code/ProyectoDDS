package modelo.personajes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Amigo extends EntidadDinamica {

	public Amigo() {
		// TODO Auto-generated constructor stub
	}

	public Amigo(TextureRegion _texturaNormal) {
		super(_texturaNormal);
	}
	
	public boolean colision(Enemigo _enemigo){
		return superficie.overlaps(_enemigo.getSuperficie());
	}
	
public boolean colision(Entidad _entidad){
	if(_entidad instanceof Enemigo) return colision((Enemigo)_entidad);
		return false;
	}	

}
