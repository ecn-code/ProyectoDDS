package modelo;


public class EstadoDerecha implements Estado{
	private EntidadDinamica entidad;
	private float acumulado;
	public EstadoDerecha(EntidadDinamica entidad){
		this.entidad=entidad;
		acumulado=0;
	}
	@Override
	public void parar() {
			entidad.setEstado(new EstadoReposo(entidad));
	}

	@Override
	public void girarDerecha(float time) {
		acumulado += time;
		entidad.setTextura(entidad.getAnimDerecha().getKeyFrame(acumulado));
	}

	@Override
	public void girarIzquierda(float time) {
		// TODO Auto-generated method stub
		entidad.setEstado(new EstadoIzquierda(entidad));
		
		
	}

	@Override
	public void colisionar(float time) {
		// TODO Auto-generated method stub
	}

}
