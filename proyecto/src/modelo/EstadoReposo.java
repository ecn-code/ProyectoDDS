package modelo;


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
		entidad.setEstado(new EstadoExplosion(entidad));
	}
	
}
