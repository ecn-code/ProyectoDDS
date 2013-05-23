package modelo.estrategia;

import objectPool.MensajesPool;

import com.badlogic.gdx.math.Rectangle;

import modelo.Observador;
import modelo.Sujeto;
import modelo.personajes.EntidadDinamica;

public class SuprimirSubscripcion extends IEstrategia {

	public SuprimirSubscripcion(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Sujeto colegaReceptor = (Sujeto)mensaje.getDestinatario();
			colegaReceptor.suprime((Observador) mensaje.getDescripcion());
			MensajesPool.damePoolMensajes().reciclar(mensaje);
	}
}
