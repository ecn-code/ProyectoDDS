package modelo.estrategia;

import modelo.personajes.EntidadDinamica;

public class Hola extends IEstrategia {

	public Hola(Mensaje _mensaje) {
		super(_mensaje);
	}

	public void comportamiento() {
		// TODO Auto-generated method stub
		System.out.println(mensaje.getDestinatario());
	}


}
