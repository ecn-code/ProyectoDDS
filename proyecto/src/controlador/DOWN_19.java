package controlador;

import modelo.Logica;

public class DOWN_19 implements Comando{
	
		private Logica logica;
		public DOWN_19(Logica _logica){
			logica=_logica;
			//Elias
		}
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub
			logica.moverNaveY(3);
			System.out.println("Prueba");
			System.out.println("Prueba");
		}
}
