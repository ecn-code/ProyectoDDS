package modelo.estrategia;

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
			((EntidadDinamica)mensaje.getDestinatario()).getEstado().colisionar();
			if(!colegaReceptor.getCanal().equals("Extra")){
			Mensaje mensajeReenvio = new Mensaje();
			mensajeReenvio.setAsunto("ComprobarColision");
			mensajeReenvio.setDescripcion(colegaReceptor.getSuperficie());
			colegaReceptor.getMediador().enviar(mensaje.getCanalEmisor(), mensajeReenvio);		
		}
		}
	}
}
