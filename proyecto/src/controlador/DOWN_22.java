package controlador;

import modelo.Logica;
public class DOWN_22 implements Comando{
	private Logica logica;
	public DOWN_22(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		System.out.println("Apretado_3");
		// TODO Auto-generated method stub
		logica.moverNaveX(3);
	}

}
