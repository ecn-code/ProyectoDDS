package modelo;

public class Marcador {
private int cifras[];
	public Marcador() {
		cifras = new int[6];
	}
	
	public void sumar(int puntos){
		int cifra=0;
		do{
		int puntosCifra = puntos % 10;
		puntos = puntos / 10;
		if(puntosCifra+cifras[cifra]>9){ puntos += 1;
		puntosCifra =(puntosCifra+cifras[cifra])-10;
		cifras[cifra]=0;
		}
		cifras[cifra]+=puntosCifra;
		cifra++;
		
		}while(puntos>0);
		System.out.println(cifras[3]+""+cifras[2]+""+cifras[1]+""+cifras[0]);
	}

	public void reset(){
		for(int cifra : cifras) cifra=0;
	}
}
