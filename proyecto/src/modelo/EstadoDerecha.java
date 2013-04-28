package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class EstadoDerecha implements Estado{
	private Nave nave;
	public EstadoDerecha(Nave nave){
		this.nave=nave;
	}
	@Override
	public void parar(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		nave.setTextura(_textura);
		nave.setEstado(nave.getEstadoReposo());
		//meter textura normal;
		
	}

	@Override
	public void girarDerecha(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void girarIzquierda(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		nave.setTextura(_textura);
		nave.setEstado(nave.getEstadoDerecha());
		
		
	}

	@Override
	public void colisionar(AtlasRegion _textura) {
		// TODO Auto-generated method stub
	}

}
