package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.personajes.EntidadDinamica;

public class Mediador implements IMediador{
	private HashMap<String,ArrayList<Object>> colegas= new HashMap<String,ArrayList<Object>>();
	@Override
	public void registrarse(String canal,Object objeto) {
		// TODO Auto-generated method stub
		ArrayList<Object> colega=colegas.get(canal);
		if(colega!=null){
			colega.add(objeto);
		}else{
			ArrayList<Object> nuevoColega=new ArrayList<Object>();
			nuevoColega.add(objeto);
			colegas.put(canal, colega);
		}
	}

	@Override
	public void enviar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarColega(String canal, Object objeto) {
		// TODO Auto-generated method stub
		ArrayList<Object> colega=colegas.get(canal);
		if(colega!=null){
			colegas.remove(canal);
	}
	}
}