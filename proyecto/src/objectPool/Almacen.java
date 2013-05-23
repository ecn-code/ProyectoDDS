package objectPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;

import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.IFabrica;

public class Almacen {
	private HashMap<String, LinkedList<EntidadDinamica>> almacen;
	IFabrica fabrica;
	
	public Almacen(){
		almacen = new HashMap<String,LinkedList<EntidadDinamica>>();
		fabrica = new FabricaEntidadesDinamicas();
	}
	
	public void reciclar(EntidadDinamica entidad){
		LinkedList<EntidadDinamica> objetos = almacen.get(entidad.getClass().getSimpleName());
		if(objetos==null) objetos = new LinkedList<EntidadDinamica>();
		objetos.add(entidad);
		almacen.put(entidad.getClass().getSimpleName(), objetos);
	}
	
	public EntidadDinamica adquirir(String _nombreEntidad,Vector2 _parametros){
		LinkedList<EntidadDinamica> objetos = almacen.get(_nombreEntidad);
		if(objetos!=null && objetos.size()>0){
			 EntidadDinamica entidad = objetos.remove();
			 entidad.configurar(_parametros);
			 entidad.reset();
			 return entidad;
		}
		return (EntidadDinamica) fabrica.crearProducto(_nombreEntidad, _parametros);
	}
}
