package controlador;

import modelo.Logica;

public class DOWN_62 implements Comando {
	private Logica logica;
	public DOWN_62(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.crearBala();
	}

}
