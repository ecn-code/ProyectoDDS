package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class EstadoExplosion implements Estado{
private Nave nave;
public EstadoExplosion(Nave nave){
	this.nave=nave;
}
	@Override
	public void parar(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void girarDerecha(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void girarIzquierda(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionar(AtlasRegion _textura) {
		// TODO Auto-generated method stub
		
	}

	
}
