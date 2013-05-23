package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import modelo.estrategia.FabricaEstrategias;
import modelo.estrategia.IEstrategia;
import modelo.estrategia.Mensaje;
import modelo.personajes.EntidadDinamica;
import modelo.personajes.IFabrica;
import modelo.personajes.Nave;

public class Mediador implements IMediador{
	IFabrica fabricaEstrategias;
	private static Mediador mediador;
	private HashMap<String,CopyOnWriteArrayList<IColega>> hashColegas;
	
	public Mediador (){
		fabricaEstrategias =  new FabricaEstrategias();
		hashColegas = new HashMap<String,CopyOnWriteArrayList<IColega>>();
	}
	
	@Override
	public void registrarse(String canal,IColega colega) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<IColega> arrayColegas=hashColegas.get(canal);
		if(arrayColegas!=null){
			arrayColegas.add(colega);
		}else{
			CopyOnWriteArrayList<IColega> nuevoArrayColegas=new CopyOnWriteArrayList<IColega>();
			nuevoArrayColegas.add(colega);
			hashColegas.put(canal, nuevoArrayColegas);
		}
	}

	@Override
	public void enviar(String canal,Mensaje _mensaje) {
			IEstrategia estrategia = (IEstrategia) fabricaEstrategias.crearProducto(_mensaje.getAsunto(), _mensaje);
			CopyOnWriteArrayList<IColega> arrayColegas = hashColegas.get(canal);
			if(arrayColegas!=null)
			for(IColega colega : arrayColegas){
				_mensaje.setDestinatario(colega);
				colega.recibir(estrategia);
			}
	}

	@Override
	public void eliminarColega(String _canal, IColega _colega) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<IColega> arrayColegas=hashColegas.get(_canal);
		if(arrayColegas!=null){
			arrayColegas.remove(_colega);
	}
	}
	public void reset(){
		hashColegas=new HashMap<String,CopyOnWriteArrayList<IColega>>();
	}

	public static Mediador getMediador() {
		if(mediador==null)mediador = new Mediador();
		return mediador;
	}

	public EntidadDinamica getNave() {
		// TODO Auto-generated method stub
		return (EntidadDinamica) hashColegas.get("Nave").get(0);
	}
}