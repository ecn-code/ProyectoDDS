package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class Entidad {

	protected float x,y,ancho,alto;
	protected TextureRegion textura;
	public Entidad(float _x, float _y, float _ancho, float _alto,TextureRegion _textura){
		x=_x;
		y=_y;
		ancho=_ancho;
		alto=_alto;
		textura=_textura;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float _ancho) {
		ancho = _ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float _alto) {
		alto = _alto;
	}
	protected void setX(float _x){
		x=_x;
	}
	protected double getX(){
	return x;	
	}
	protected double getY() {
		return y;
	}
	protected void setY(float _y) {
		y = _y;
	}
	protected TextureRegion getTextura() {
		return textura;
	}
	protected void setTextura(TextureRegion _textura) {
		textura = _textura;
	}
}