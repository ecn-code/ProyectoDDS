package modelo.personajes;

import modelo.Movimiento;
import modelo.decorador.ExtraVelocidad;
import modelo.estado.Estado;
import modelo.estado.EstadoReposo;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class EntidadDinamica extends Entidad {
	protected String tipoMovimiento = "";
	protected Estado estado;
	protected boolean animacionLoop;
	protected Animation  animIzquierda,animDerecha;
	protected Animation animExplosion;
	protected Movimiento movimiento;
	public  EntidadDinamica() {
		super();
	}
	
	public boolean esAnimacionLoop (){
		return animacionLoop;
	}
	
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public EntidadDinamica(TextureRegion _texturaNormal){
		super(_texturaNormal);
		estado = new EstadoReposo(this);
		movimiento= new Movimiento();
	}
	
	public void actualizar(float time){
		estado.mover(getVx());
		estado.actualizarTextura(time);
		sumarX(getVx()*time);
		sumarY(getVy()*time);
		}
	public float getVx() {
		return movimiento.getVx();
	}
	public void setVx(float _vx) {
		movimiento.setVx(_vx);
	}
	public float getVy() {
		return movimiento.getVy();
	}
	public void setVy(float _vy) {
		movimiento.setVy(_vy);
	}
	public void sumarX(float _x){
		superficie.setX(superficie.getX()+_x);
	}
	public void sumarY(float _y){
		superficie.setY(superficie.getY()+_y);
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Estado getEstado() {
		return this.estado ;
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
	}
public Animation getAnimExplosion() {
	// TODO Auto-generated method stub
	return animExplosion;
}

public Movimiento getMovimiento() {
	return movimiento;
}

public void setMovimiento(Movimiento movimiento) {
	this.movimiento = movimiento;
}

public void setAnimIzquierda(Animation animIzquierda) {
	this.animIzquierda = animIzquierda;
}

public void setAnimDerecha(Animation animDerecha) {
	this.animDerecha = animDerecha;
}

public void setAnimExplosion(Animation animExplosion) {
	this.animExplosion = animExplosion;
}

}
