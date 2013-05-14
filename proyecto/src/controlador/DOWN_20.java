package controlador;

import modelo.Logica;

public class DOWN_20 implements Comando{
	private Logica logica;
	public DOWN_20(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		System.out.println("Apretado_3");
		// TODO Auto-generated method stub
		logica.moverNaveY(-3);
	}
}
