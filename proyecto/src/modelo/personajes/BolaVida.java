package modelo.personajes;

import modelo.Constantes;
import modelo.estrategia.Mensaje;
import vista.Recursos;

public class BolaVida extends EntidadDinamica{
public BolaVida(){
	super(Recursos.bolaVida);
	reset();
}
@Override
public void eliminarSubscripcion(){
	super.eliminarSubscripcion();
	Mensaje mensajeParaLogica = new Mensaje();
	mensajeParaLogica.setAsunto("DecorarVida");
	mediador.enviar("Logica", mensajeParaLogica);
}
@Override
public void reset() {
	setAncho(35);
	setAlto(35);
	animExplosion = Recursos.animExplosion;
	animDerecha = Recursos.animBolaVidaDerecha;
	animIzquierda = Recursos.animBolaVidaIzquierda;
	puntos=30;
	setVy(-Constantes.velocidadBolaVida);
	setVx(0);
	setVida(2);
	canal="Extra";
	registrarseEnElMediador(canal);
	tipoMovimiento = "aleatorio";
}
}
