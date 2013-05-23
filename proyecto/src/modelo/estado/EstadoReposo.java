package modelo.estado;

import modelo.decorador.ExtraVelocidad;
import modelo.estrategia.Mensaje;
import modelo.personajes.Bala;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.Nave;


public class EstadoReposo implements Estado{
	private EntidadDinamica entidad;
	public EstadoReposo(EntidadDinamica entidad){
		this.entidad=entidad;
	}
	@Override
	public void actualizarTextura(float time) {
		entidad.setTextura(entidad.getTexturaNormal());
	}
	@Override
	public void mover(float vx) {
		if(vx>0) entidad.setEstado(new EstadoDerecha(entidad));
		else if(vx<0) entidad.setEstado(new EstadoIzquierda(entidad));
	}
	@Override
	public void colisionar() {
		if(entidad.getVida()<=0){
		entidad.setEstado(new EstadoExplosion(entidad));
		entidad.eliminarColega();
		}
	}
	
}
