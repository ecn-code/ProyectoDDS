package modelo.personajes;

import modelo.Constantes;
import modelo.estrategia.Mensaje;
import vista.Recursos;

public class BolaVelocidad extends EntidadDinamica{
	public BolaVelocidad(){
	super(Recursos.bolaVelocidad);
	reset();
	}
	@Override
	public void eliminarSubscripcion(){
		super.eliminarSubscripcion();
		Mensaje mensajeParaLogica = new Mensaje();
		mensajeParaLogica.setAsunto("DecorarVelocidad");
		mediador.enviar("Logica", mensajeParaLogica);
	}
	@Override
	public void reset() {
		setAncho(35);
		setAlto(35);
		animExplosion = Recursos.animExplosion;
		animDerecha = Recursos.animBolaVelocidadDerecha;
		animIzquierda = Recursos.animBolaVelocidadIzquierda;
		puntos=30;
		setVy(-Constantes.velocidadBolaVelocidad);
		setVx(0);
		setVida(2);
		canal="Extra";
		canalesDeColision=new String[]{""};
		registrarseEnElMediador(canal);
		tipoMovimiento = "aleatorio";
	}

}
