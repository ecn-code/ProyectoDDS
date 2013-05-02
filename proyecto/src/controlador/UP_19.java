package controlador;

import modelo.Logica;

public class UP_19 implements Comando {
	private Logica logica;
	public UP_19(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.moverNaveY(0);
	}
}
