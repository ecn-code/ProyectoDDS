package controlador;

import modelo.Logica;

public class DOWN_21 implements Comando{
	private Logica logica;
	public DOWN_21(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.moverNaveX(-3);
	}
}