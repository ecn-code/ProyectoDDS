package modelo;

import vista.Recursos;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class EntidadDinamica extends Entidad {
	protected float vx,vy;
	protected Estado estado;
	protected Animation  animIzquierda,animDerecha;
	public  EntidadDinamica() {
		super();
	}
	public EntidadDinamica(TextureRegion _texturaNormal){
		super(_texturaNormal);
		estado = new EstadoReposo(this);
	}
	public EntidadDinamica(float _x,float _y,float _ancho, float _alto,float _vx,float _vy,TextureRegion _textura){
		super(_x, _y,_ancho,_alto,_textura);
		vx=_vx;
		vy=_vy;
		estado = new EstadoReposo(this);
	}
	public void actualizar(float time){
		if(vx>0) estado.girarDerecha(time);
		else if(vx<0) estado.girarIzquierda(time);
		else estado.parar();
		sumarX(vx);
		sumarY(vy);
	}
	public float getVx() {
		return vx;
	}
	public void setVx(float _vx) {
		vx = _vx;
	}
	public float getVy() {
		return vy;
	}
	public void setVy(float _vy) {
		vy = _vy;
	}
	public void sumarX(float _x){
		superficie.setX(superficie.getX()+_x);
	}
	public void sumarY(float _y){
		superficie.setY(superficie.getY()+_y);
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Animation getAnimIzquierda(){
		return animIzquierda;
	}
	public Animation getAnimDerecha() {
		// TODO Auto-generated method stub
		return animDerecha;
	}
public void configurar(float[] parametros) {
		superficie = new Rectangle(parametros[0],parametros[1], getAncho(), getAlto());
		vx= parametros[2];
		vy=parametros[3];
	}
}
