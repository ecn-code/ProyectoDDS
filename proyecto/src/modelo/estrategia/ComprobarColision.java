package modelo.estrategia;

import objectPool.MensajesPool;

import com.badlogic.gdx.math.Rectangle;

import modelo.IColega;
import modelo.personajes.Bala;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.MocoRojo;

public class ComprobarColision extends IEstrategia {

	public ComprobarColision(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Rectangle superficie = (Rectangle)mensaje.getDescripcion();
		EntidadDinamica colegaReceptor = (EntidadDinamica)mensaje.getDestinatario();
		boolean colision = colegaReceptor.colision(superficie);
		if(colision){
			colegaReceptor.setVida(colegaReceptor.getVida()-1);
			MensajesPool.damePoolMensajes().reciclar(mensaje);
			((EntidadDinamica)mensaje.getDestinatario()).getEstado().colisionar();
			Mensaje mensajeReenvio = MensajesPool.damePoolMensajes().adquirir();
			mensajeReenvio.setAsunto("ComprobarColision");
			mensajeReenvio.setDescripcion(colegaReceptor.getSuperficie());
			colegaReceptor.getMediador().enviar(mensaje.getCanalEmisor(), mensajeReenvio);		
		}

	}
}
