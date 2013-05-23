package controlador;

import modelo.Logica;

public class UP_20 implements Comando {
	private Logica logica;
	public UP_20(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.moverNaveY(0);
	}
}
