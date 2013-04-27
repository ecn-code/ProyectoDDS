package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface InterfazFabrica {
Entidad crearEntidad(String name,float [] parametros,AtlasRegion textura);
}
