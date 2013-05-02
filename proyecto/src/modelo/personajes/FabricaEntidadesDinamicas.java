package modelo.personajes;



public class FabricaEntidadesDinamicas implements InterfazFabricaEntidad {
	private EntidadDinamica entidad;
	@Override
	public EntidadDinamica crearEntidad(String nombreClase,float [] parametros) {
		
		try {
				Class<?> clase = Class.forName("modelo.personajes."+nombreClase);
				Object object = clase.newInstance();
				entidad = (EntidadDinamica) object;
				entidad.configurar(parametros);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		return entidad;
		
	}

}
