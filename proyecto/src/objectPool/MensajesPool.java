package objectPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;

import modelo.estrategia.Mensaje;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.FabricaEntidadesDinamicas;
import modelo.personajes.IFabrica;

public class MensajesPool {
	private static LinkedList<Mensaje> almacen;
	static MensajesPool mensajesPool;
	
	public static MensajesPool damePoolMensajes(){
		if(mensajesPool==null) mensajesPool = new MensajesPool();
		return mensajesPool;
	}
	
	public MensajesPool(){
		almacen = new LinkedList<Mensaje>();
	}
	
	public void reciclar(Mensaje _mensaje){
		almacen.add(_mensaje);
	}
	
	public Mensaje adquirir(){
		if(almacen.size()>0){
			 Mensaje mensaje = almacen.remove();
			 return mensaje;
		}
		return new Mensaje();
	}
}
