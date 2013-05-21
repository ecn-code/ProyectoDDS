package modelo.estrategia;

import controlador.Comando;
import modelo.Logica;
import modelo.personajes.IFabrica;



public class FabricaEstrategias implements IFabrica {
	private IEstrategia estrategia;
	@Override
	public IEstrategia crearProducto(String nombreEstrategia,Object mensaje) {
		
		try {
				Class<?> claseEstrategia = Class.forName("modelo.estrategia."+nombreEstrategia);		
				Object object = claseEstrategia.getDeclaredConstructor(Mensaje.class).newInstance(mensaje);
				estrategia = (IEstrategia) object;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		return estrategia;
		
	}
	
}
