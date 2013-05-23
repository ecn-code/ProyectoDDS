package controlador;

import modelo.Constantes;
import modelo.Logica;

public class DOWN_20 implements Comando{
	private Logica logica;
	public DOWN_20(Logica _logica){
		logica=_logica;
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		logica.moverNaveY(-Constantes.velocidadNave);
	}
}
