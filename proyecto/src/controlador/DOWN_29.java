package controlador;

import modelo.Logica;

public class DOWN_29 implements Comando{
	
		private Logica logica;
		public DOWN_29(Logica _logica){
			logica=_logica;
			//Elias
		}
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			logica.crearBala();
		}
}
