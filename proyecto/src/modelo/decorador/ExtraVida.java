package modelo.decorador;

import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;

public class ExtraVida extends Decorador {

	public ExtraVida(EntidadDinamica _componente) {
		super(_componente);
		componente.setVida(componente.getVida()+2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getVx() {
		// TODO Auto-generated method stub
		return componente.getVx();
	}

	@Override
	public float getVy() {
		// TODO Auto-generated method stub
		return componente.getVy();
	}

}
