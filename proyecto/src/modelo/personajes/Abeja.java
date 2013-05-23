package modelo.personajes;

import modelo.Constantes;
import vista.Recursos;

public class Abeja extends Enemigo{
public Abeja(){
	super(Recursos.abeja1);
	reset();
}

public void reset(){
	setAncho(32);
	setAlto(30);
	animExplosion = Recursos.animExplosion;
	puntos=30;
	setVy(-Constantes.velocidadAveja);
	setVx(0.1f);
	setVida(1);
	animDerecha = Recursos.animAbeja;
	animIzquierda = Recursos.animAbeja;
	puntos = 10;
	tipoMovimiento = "aleatorio";
	posMovimiento=0;
	resetMovimientos();
	canal="Enemigo";
	registrarseEnElMediador(canal);
	canalesDeColision=new String[]{"Amigo"};
}

public boolean disparo(){
	return Math.random()*10+Math.random()*3<1;
}

public void resetMovimientos(){
	movimientos = Constantes.movimientoAbeja.clone();
}


}
