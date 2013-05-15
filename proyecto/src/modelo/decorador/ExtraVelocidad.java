package modelo.decorador;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import modelo.estado.Estado;
import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;

public class ExtraVelocidad extends Decorador{
	
public ExtraVelocidad(EntidadDinamica _entidad){
	super(_entidad);
}
	@Override
	public float getVx() {
		// TODO Auto-generated method stub
		return 1.5f*componente.getVx();
	}
	@Override
	public float getVy() {
		// TODO Auto-generated method stub
		return 1.5f*componente.getVy();
	}
	

	
	
}
