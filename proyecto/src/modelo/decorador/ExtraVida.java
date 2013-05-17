package modelo.decorador;

import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;

public class ExtraVida extends Decorador {
	int vidaExtra = 2;

	public ExtraVida(EntidadDinamica _componente) {
		super(_componente);
	}
	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return componente.getVida()+vidaExtra;
	}
	@Override
	public void setVida(int _vida) {
		// TODO Auto-generated method stub
		componente.setVida(_vida-vidaExtra);
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
