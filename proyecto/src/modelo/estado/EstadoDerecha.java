package modelo.estado;

import modelo.decorador.ExtraVelocidad;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.Nave;


public class EstadoDerecha implements Estado{
	private EntidadDinamica entidad;
	private float acumulado;
	public EstadoDerecha(EntidadDinamica entidad){
		this.entidad=entidad;
		acumulado=0;
	}
	@Override
	public void actualizarTextura(float time) {
		acumulado += time;
		entidad.setTextura(entidad.getAnimDerecha().getKeyFrame(acumulado,entidad.esAnimacionLoop()));
	}
	@Override
	public void mover(float vx) {
		if(entidad instanceof Nave){
		}
		if(vx<0) entidad.setEstado(new EstadoIzquierda(entidad));
		else if(vx==0) entidad.setEstado(new EstadoReposo(entidad));
	}
	@Override
	public void colisionar() {
		entidad.setEstado(new EstadoExplosion(entidad));
	}
	
}
