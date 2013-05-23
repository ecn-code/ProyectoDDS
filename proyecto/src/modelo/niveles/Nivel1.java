package modelo.niveles;

import java.util.ArrayList;

public class Nivel1 {
	private static final String[][] nivel1 = new String[][]{

			{"","","","","","","","Nave","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","JefeRajoy","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","Abeja","Abeja","Abeja"},
			{"","","","","","","","Abeja","Abeja","Abeja","","","","",""},
			{"","","Abeja","Abeja","Abeja","","","","","","","","","",""},
			{"","","","","","","","","","","","","Abeja","Abeja","Abeja"},
			{"","","","","","","","","","","","","","",""},
			{"","","Libelula","","","Libelula","","","Libelula","","","Libelula","","",""},
			{"","","","","","","","","","","","","","",""},
			{"Libelula","","","Libelula","","","","Libelula","","","Libelula","","","Libelula",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","BolaVida","","BolaVelocidad"},
			{"","","","","","","","","","","","","","",""},
			{"MocoRojo","","","MocoRojo","","","MocoRojo","","","MocoRojo","","","MocoRojo","",""},
			{"","","","","","","","","","BolaVida","","","","",""},
			{"","","MocoRojo","","","MocoRojo","","","MocoRojo","","","MocoRojo","","","MocoRojo"},
			{"","","","","","","BolaVelocidad","","","","","","","",""},
			{"Ciclope","","","Ciclope","","","","Ciclope","","","","Ciclope","","","Ciclope"},
			{"","","","Ciclope","","","","","","Ciclope","","","","",""},
			{"","","Libelula","","","Libelula","","","Libelula","","","Libelula","","","Libelula"},
			{"","","","","","","","JefeRajoy","","","","","","",""}
	};

	int filaActual=0;
	public Nivel1(){
		}
	
	public ArrayList<String> getFila(int numFilas){
		ArrayList<String> fila= new ArrayList<String>();
		if(filaActual+numFilas<=nivel1.length)
		for(int j=0;j<numFilas;j++){
		for(int i=0;i<nivel1[filaActual].length;i++){
			fila.add(nivel1[filaActual][i]);
		}
		filaActual++;
		}
		return fila;
	}

	public int getFilaActual() {
		return filaActual;
	}
}
