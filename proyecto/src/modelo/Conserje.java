package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

import modelo.personajes.EntidadDinamica;

public class Conserje {
	Memento[] array;
	int primeraPosicionArray;
	private int cantidadMementos=0;
	public Conserje(){
		array=new Memento[10];
		primeraPosicionArray=0;
	}
	public void addMemento(Memento memento){
		if(cantidadMementos<10)cantidadMementos++;
	if(primeraPosicionArray<9){
		array[primeraPosicionArray]=memento;
		primeraPosicionArray++;
	}else{
		array[primeraPosicionArray]=memento;
		primeraPosicionArray=0;

		
	}
	}	public Memento getMemento(){
		Memento m=null;
		if(cantidadMementos>0){
			
	
		m= array[primeraPosicionArray];
		primeraPosicionArray--;
		cantidadMementos--;
	if(primeraPosicionArray<0)primeraPosicionArray=9;
		}
		return m;
	}
	
	public ArrayList<Memento> getMementos(){
		int i=primeraPosicionArray;
		ArrayList<Memento> mementos= new ArrayList<Memento>();
		for(int numeroMementos=0;numeroMementos<9;numeroMementos++){
			if(array[i]!=null){
				if(i<9){
				mementos.add(array[i]);
				i++;
				}else{
				mementos.add(array[i]);
				i=0;
				}			
			}else{
			break;
			}
		}
		return mementos;
	}
	
}
