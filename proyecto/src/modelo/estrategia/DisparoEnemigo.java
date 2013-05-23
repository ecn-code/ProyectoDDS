package modelo.estrategia;


import objectPool.MensajesPool;

import com.badlogic.gdx.math.Vector2;

import modelo.Logica;

public class DisparoEnemigo extends IEstrategia {

	public DisparoEnemigo(Mensaje _mensaje) {
		super(_mensaje);
	}

	@Override
	public void comportamiento() {
		Logica colegaReceptor = (Logica)mensaje.getDestinatario();
			colegaReceptor.crearBalaEnemigo((Vector2) mensaje.getDescripcion());
			MensajesPool.damePoolMensajes().reciclar(mensaje);
	}
}
