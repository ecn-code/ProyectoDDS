package modelo.personajes;



public class FabricaEntidadesDinamicas implements IFabrica {
	private EntidadDinamica entidad;
	@Override
	public EntidadDinamica crearProducto(String nombreClase,Object parametros) {
		
		try {
				Class<?> clase = Class.forName("modelo.personajes."+nombreClase);
				Object object = clase.newInstance();
				entidad = (EntidadDinamica) object;
				entidad.configurar((float[]) parametros);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		return entidad;
		
	}

}
