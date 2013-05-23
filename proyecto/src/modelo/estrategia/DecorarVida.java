package modelo.estrategia;

import com.badlogic.gdx.math.Rectangle;

import modelo.Logica;
import modelo.Observador;
import modelo.Sujeto;
import modelo.personajes.EntidadDinamica;

public class DecorarVida extends IEstrategia {

	public DecorarVida(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Logica colegaReceptor = (Logica)mensaje.getDestinatario();
			colegaReceptor.decorarVida();
	}
}
