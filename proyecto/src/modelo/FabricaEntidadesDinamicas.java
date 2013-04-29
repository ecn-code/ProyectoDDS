package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FabricaEntidadesDinamicas implements InterfazFabrica {
	@Override
	public Entidad crearEntidad(String name,float [] parametros, AtlasRegion textura ) {
		// TODO Auto-generated method stub
		if(name.equals("Bala")){
			return new Bala(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name.equals("BalaEnemigo")){
			return new BalaEnemigo(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name.equals("libelula")){
			return new Enemigo(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name.equals("Nave")){
			return new Nave(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name.equals("mocoRojo")){
			return new Enemigo(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		} 
			return null;			
	}

}
