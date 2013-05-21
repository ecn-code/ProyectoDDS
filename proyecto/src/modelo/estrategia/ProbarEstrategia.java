package modelo.estrategia;

import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.IFabrica;

public class ProbarEstrategia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IFabrica fabrica = new FabricaEstrategias();
		Mensaje mensaje = new Mensaje();
		mensaje.setDestinatario("Hola estrategia");
		IEstrategia estrategia = (IEstrategia) fabrica.crearProducto("Hola", mensaje);
		estrategia.comportamiento();
	}

}
