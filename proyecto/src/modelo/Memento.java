package modelo;

import java.util.LinkedList;

import modelo.personajes.EntidadDinamica;

public class Memento {
	private LinkedList<EntidadDinamica>  array;
	public Memento(LinkedList<EntidadDinamica> _array){
		array=_array;
	}
	public LinkedList<EntidadDinamica> getEstado(){
		return array;
	}
}
