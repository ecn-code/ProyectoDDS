package modelo.personajes;

import modelo.IColega;
import modelo.Mediador;
import modelo.estrategia.IEstrategia;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;



public abstract class Entidad implements IColega{

	protected Rectangle superficie;
	protected TextureRegion textura;
	protected TextureRegion texturaNormal;
	protected boolean eliminar;
	protected int puntos=0;
	protected int vida;
	protected boolean explosiona=false;
	public Entidad(){
	}
	public Entidad(TextureRegion _texturaNormal){
		textura = _texturaNormal;
		texturaNormal = _texturaNormal;
		superficie = new Rectangle();
		eliminar=false;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public boolean isEliminar() {
		return eliminar;
	}
	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	public Entidad(float _x, float _y, float _ancho, float _alto,TextureRegion _textura){
		superficie = new Rectangle(_x, _y, _ancho, _alto);
		textura = _textura;
		texturaNormal = textura;
	} 
	public TextureRegion getTexturaNormal() {
		return texturaNormal;
	}
	public void setTexturaNormal(TextureRegion texturaNormal) {
		this.texturaNormal = texturaNormal;
	}
	public float getAncho() {
		return superficie.getWidth();
	}
	public void setAncho(float _ancho) {
		superficie.setWidth(_ancho);
	}
	public float getAlto() {
		return superficie.getHeight();
	}
	public void setAlto(float _alto) {
		superficie.setHeight(_alto);
	}
	public void setX(float _x){
		superficie.setX(_x);
	}
	public float getX(){
	return superficie.getX();
	}
	public float getY() {
		return superficie.getY();
	}
	public void setY(float _y) {
		superficie.setY(_y);
	}
	public TextureRegion getTextura() {
		return textura;
	}
	public void setTextura(TextureRegion _textura) {
		textura = _textura;
	}
	public int getPuntos(){
		return puntos;
	}
	public void setPuntos(int _puntos){
		puntos=_puntos;
	}
	
	public boolean colision(Rectangle _superficie){
		return this.superficie.overlaps(_superficie);
	}
	
	public Rectangle getSuperficie(){
		return superficie;
	}
	public boolean disparo(){
		return false;
	}
	public boolean getExplosiona() {
		return explosiona;
	}
	public void setExplosiona(boolean explosiona) {
		this.explosiona = explosiona;
	}
	public void dibujar(SpriteBatch batch) {
		batch.draw(getTextura(), getX(), getY(), getAncho(), getAlto());
	}
	public void recibir(IEstrategia estrategia){
		estrategia.comportamiento();
	}
	public abstract void reset();
}