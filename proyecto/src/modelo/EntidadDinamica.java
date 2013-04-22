package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class EntidadDinamica extends Entidad {
	protected float vx,vy;
	public EntidadDinamica(float _x,float _y,float _ancho, float _alto,float _vx,float _vy,TextureRegion _textura){
		super(_x, _y,_ancho,_alto,_textura);
		vx=_vx;
		vy=_vy;
	}
	public void actualizar(float time){
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
}
