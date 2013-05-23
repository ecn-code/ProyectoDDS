package modelo;

import modelo.estrategia.IEstrategia;

public class SujetoActualizar extends Sujeto implements IColega{

	@Override
	public void recibir(IEstrategia estrategia) {
		estrategia.comportamiento();
	}

}
