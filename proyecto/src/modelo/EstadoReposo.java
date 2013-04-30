package modelo;


public class EstadoReposo implements Estado{
	private EntidadDinamica entidad;
	public EstadoReposo(EntidadDinamica entidad){
		this.entidad=entidad;
	}
	@Override
	public void parar() {
		entidad.setTextura(entidad.getTexturaNormal());
	}
	@Override
	public void girarDerecha(float time) {
		entidad.setEstado(new EstadoDerecha(entidad));
	}
	@Override
	public void girarIzquierda(float time) {
		entidad.setEstado(new EstadoIzquierda(entidad));
	}
	@Override
	public void colisionar(float time) {
		entidad.setEstado(new EstadoExplosion(entidad));
	}
	
	

}
