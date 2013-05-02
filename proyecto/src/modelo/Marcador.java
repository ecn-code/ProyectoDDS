package modelo;

import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Marcador {
private int cifras[],x=0,y=550,w=20,h=20;
public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getW() {
	return w;
}

public void setW(int w) {
	this.w = w;
}

public int getH() {
	return h;
}

public void setH(int h) {
	this.h = h;
}

private TextureRegion texturas[];
	public Marcador() {
		cifras = new int[6];
		texturas = new TextureRegion[6];
	}
	
	public TextureRegion[] getTexturas(){
		return texturas;
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
		actualizar();
	}

	public void reset(){
		for(int cifra : cifras) cifra=0;
		actualizar();
	}
	
	public void actualizar(){
		int indice = 0;
		for(int cifra : cifras){ texturas[indice++]=Recursos.marcadorTexturas[cifra];	}	
	}
}
