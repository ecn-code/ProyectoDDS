package modelo.personajes;

import modelo.Constantes;
import modelo.estrategia.Mensaje;
import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Bala extends EntidadDinamica {
	public Bala(){
		super(Recursos.bala);
	setAncho(30);
	setAlto(30);
	setVx(0);
	setVy(Constantes.velocidadBala);
	setVida(1);
	animExplosion = Recursos.animExplosionBala;
	canal="BalaPersonaje";
	canalesDeColision=new String[]{"Enemigo"};
	registrarseEnElMediador(canal);
	}
	
public void actualizar(float time){
	super.actualizar(time);
	if(!explosiona){
	Mensaje mensaje = new Mensaje();
	mensaje.setDescripcion(this.getSuperficie());
	mensaje.setAsunto("ComprobarColision");
	mensaje.setCanalEmisor(canal);
	for(String _canal : canalesDeColision)
		mediador.enviar(_canal, mensaje);
}}

}