package modelo.estrategia;

import modelo.IColega;
import modelo.IMediador;
import modelo.Mediador;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.IFabrica;

public class ProbarEstrategia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IMediador mediador = new Mediador();
		IColega colega1 = new ColegaPrueba(mediador);
		IColega colega2 = new ColegaPrueba(mediador);
		mediador.registrarse("Saludo1", colega1);
		mediador.registrarse("Saludo2", colega2);
		Mensaje mensaje = new Mensaje();
		mensaje.setAsunto("Hola");
		((ColegaPrueba) colega1).enviar("Saludo2",mensaje);
	}

}
