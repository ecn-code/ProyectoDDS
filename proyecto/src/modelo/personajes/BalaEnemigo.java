package modelo.personajes;

import modelo.Constantes;
import modelo.estrategia.Mensaje;
import vista.Recursos;


public class BalaEnemigo extends Enemigo{
	public BalaEnemigo(){
		super(Recursos.balaEnemiga);
	setAncho(10);
	setAlto(10);
	setVx(0);
	setVy(-Constantes.velocidadBalaEnemigo);
	setVida(1);
	animExplosion = Recursos.animExplosion;
	canal = "BalaEnemigo";
	registrarseEnElMediador(canal);
	canalesDeColision=new String[]{"Nave"};
	}
	@Override
	public void eliminarSubscripcion(){
		super.eliminarSubscripcion();
		Mensaje mensajeParaLogica = new Mensaje();
		mensajeParaLogica.setAsunto("DecorarVelocidad");
		mediador.enviar("Logica", mensajeParaLogica);
	}

}
