package modelo.niveles;

import java.util.ArrayList;

public class Nivel1 {
	private static final String[][] nivel1 = new String[][]{
			{"","Nave",""},{"","",""},{"","libelula","mocoRojo"},
			{"libelula","mocoRojo","libelula"},{"","",""},
			{"mocoRojo","mocoRojo",""}};
	int nFila=0;
	public Nivel1(){
		}
	
	public ArrayList<String> getFila(){
		ArrayList<String> fila= new ArrayList<String>();
		for(int i=0;i<nivel1[nFila].length;i++){
			fila.add(nivel1[nFila][i]);
		}
		nFila++;
		return fila;
	}
}
