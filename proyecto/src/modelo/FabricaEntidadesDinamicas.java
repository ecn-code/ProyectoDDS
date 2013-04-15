package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FabricaEntidadesDinamicas implements InterfazFabrica {
	@Override
	public Entidad crearEntidad(String name,float [] parametros, TextureRegion textura ) {
		// TODO Auto-generated method stub
		if(name=="Bala"){
			return new Bala(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name=="Enemigo"){
			return new Enemigo(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}else if(name=="Personaje"){
			return new Personaje(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], textura);
		}
			return null;			
	}

}
