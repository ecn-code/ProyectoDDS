package modelo.estado;

import modelo.personajes.EntidadDinamica;
import modelo.personajes.Nave;


public class EstadoExplosion implements Estado{
private EntidadDinamica entidad;
private float acumulado;
public EstadoExplosion(EntidadDinamica entidad){
	this.entidad=entidad;
	entidad.setExplosiona(true);
}
@Override
public void actualizarTextura(float time) {
	acumulado += time;
	if(entidad instanceof Nave){
		System.out.println("entra en actualizr");
	}
	entidad.setTextura(entidad.getAnimExplosion().getKeyFrame(acumulado));
	if(entidad.getAnimExplosion().isAnimationFinished(acumulado)) 
		entidad.setEliminar(true);
	entidad.setVx(0);
	entidad.setVy(0);
}
@Override
public void mover(float vx) {
}
@Override
public void colisionar() {
	// TODO Auto-generated method stub
	
}
}
