package modelo;

import vista.Recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Marcador {
private int valorCifra[],posX,posY,ancho,alto;
private TextureRegion imagenCifra[];
private int puntosTotal;

public int getPuntosTotal() {
	return puntosTotal;
}


public void setPuntosTotal(int puntosTotal) {
	this.puntosTotal = puntosTotal;
}


public Marcador(int _posX,int _posY, int _ancho, int _alto){
	posX = _posX;
	posY = _posY;
	ancho = _ancho;
	alto = _alto;
	puntosTotal=0;
}


public int getPosX() {
	return posX;
}

public void setPosX(int _posX) {
	this.posX = _posX;
}

public int getPosY() {
	return posY;
}

public void setPosY(int _posY) {
	this.posY = _posY;
}

public int getAncho() {
	return ancho;
}

public void setAncho(int _ancho) {
	this.ancho = _ancho;
}

public int getAlto() {
	return alto;
}

public void setAlto(int _alto) {
	this.alto = _alto;
}


	public Marcador() {
		valorCifra = new int[Constantes.numeroCifrasMarcador];
		imagenCifra = new TextureRegion[Constantes.numeroCifrasMarcador];
		posX=0;
		posY=Gdx.graphics.getHeight()-50;
		ancho=20;
		alto=20;
		puntosTotal = 0;
	}
	
	public TextureRegion[] getTexturas(){
		return imagenCifra;
	}
	
	public void sumar(int puntos){
		puntosTotal += puntos;
		int numeroCifra=0;
		do{
		int puntosCifra = puntos % 10;
		puntos = puntos / 10;
		if(puntosCifra+valorCifra[numeroCifra]>9){ puntos += 1;
		puntosCifra =(puntosCifra+valorCifra[numeroCifra])-10;
		valorCifra[numeroCifra]=0;
		}
		valorCifra[numeroCifra]+=puntosCifra;
		numeroCifra++;
		
		}while(puntos>0 && numeroCifra<valorCifra.length);
		actualizar();
	}

	public void reset(){
		for(int cifra : valorCifra) cifra=0;
		actualizar();
	}
	
	public void actualizar(){
		int indice = 0;
		for(int cifra : valorCifra){ imagenCifra[indice++]=Recursos.marcadorTexturas[cifra];	}	
	}


}
