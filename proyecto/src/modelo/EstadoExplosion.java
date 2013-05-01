package modelo;


public class EstadoExplosion implements Estado{
private EntidadDinamica entidad;
private float acumulado;
public EstadoExplosion(EntidadDinamica entidad){
	this.entidad=entidad;
}
@Override
public void actualizarTextura(float time) {
	acumulado += time;
	entidad.setTextura(entidad.getAnimExplosion().getKeyFrame(acumulado));
	if(entidad.getAnimExplosion().isAnimationFinished(acumulado)) entidad.setEliminar(true);
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
