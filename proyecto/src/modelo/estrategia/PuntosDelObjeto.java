package modelo.estrategia;

import objectPool.MensajesPool;

import com.badlogic.gdx.math.Rectangle;

import modelo.Logica;
import modelo.Observador;
import modelo.Sujeto;
import modelo.personajes.EntidadDinamica;

public class PuntosDelObjeto extends IEstrategia {

	public PuntosDelObjeto(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Logica colegaReceptor = (Logica)mensaje.getDestinatario();
			colegaReceptor.puntua((Integer) mensaje.getDescripcion());
			MensajesPool.damePoolMensajes().reciclar(mensaje);
	}
}
