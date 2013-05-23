package modelo.estrategia;

import objectPool.MensajesPool;

import com.badlogic.gdx.math.Rectangle;

import modelo.IColega;
import modelo.personajes.Bala;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.MocoRojo;

public class ComprobarFueraPantalla extends IEstrategia {

	public ComprobarFueraPantalla(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Rectangle superficie = (Rectangle)mensaje.getDescripcion();
		EntidadDinamica colegaReceptor = (EntidadDinamica)mensaje.getDestinatario();
		boolean colision = colegaReceptor.colision(superficie);
		if(colision){
			
			colegaReceptor.eliminarSubscripcion();
			
			colegaReceptor.eliminarColega();
		
		}
		MensajesPool.damePoolMensajes().reciclar(mensaje);
	}
	
}
