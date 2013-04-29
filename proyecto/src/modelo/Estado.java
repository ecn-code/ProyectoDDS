package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public interface Estado {
public void parar(AtlasRegion _textura);
public void girarDerecha(AtlasRegion _textura);
public void girarIzquierda(AtlasRegion _textura);
public void colisionar(AtlasRegion _textura);
}
