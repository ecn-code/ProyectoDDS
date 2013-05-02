package controlador;

import modelo.Logica;
public class DOWN_22 implements Comando{
	private Logica logica;
	public DOWN_22(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.moverNaveX(3);
	}

}
