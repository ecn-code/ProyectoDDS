package modelo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EntidadDinamica extends Entidad {
	protected float vx,vy;
	public EntidadDinamica(float _x,float _y,float _ancho, float _alto,float _vx,float _vy,TextureRegion _textura){
		super(_x, _y,_ancho,_alto,_textura);
		vx=_vx;
		vy=_vy;
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
}
