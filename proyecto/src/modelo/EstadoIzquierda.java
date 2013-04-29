package modelo;


public class EstadoIzquierda implements Estado{
	private EntidadDinamica entidad;
	private float acumulado;
	public EstadoIzquierda(EntidadDinamica entidad){
		this.entidad=entidad;
		acumulado = 0;
	}
	@Override
	public void parar() {
		entidad.setEstado(new EstadoReposo(entidad));
	}
	@Override
	public void girarDerecha(float time) {
		entidad.setEstado(new EstadoDerecha(entidad));
	}
	@Override
	public void girarIzquierda(float time) {
	acumulado += time;
	entidad.setTextura(entidad.getAnimIzquierda().getKeyFrame(acumulado));
	}
	@Override
	public void colisionar(float time) {
		entidad.setEstado(new EstadoExplosion(entidad));
	}

	
}
