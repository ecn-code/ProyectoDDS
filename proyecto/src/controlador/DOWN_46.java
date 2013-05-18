package controlador;

import modelo.Constantes;
import modelo.Logica;

public class DOWN_46 implements Comando{
	private Logica logica;
	public DOWN_46(Logica _logica){
		logica=_logica;
	}
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.setMementoActivado(true);
	}
}
