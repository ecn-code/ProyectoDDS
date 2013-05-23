package modelo.personajes;

import com.badlogic.gdx.math.Vector2;



public class FabricaEntidadesDinamicas implements IFabrica {
	private EntidadDinamica entidad;
	@Override
	public EntidadDinamica crearProducto(String nombreClase,Object parametros) {
		
		try {
				Class<?> clase = Class.forName("modelo.personajes."+nombreClase);
				Object object = clase.newInstance();
				entidad = (EntidadDinamica) object;
				entidad.configurar((Vector2) parametros);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		return entidad;
		
	}

}
