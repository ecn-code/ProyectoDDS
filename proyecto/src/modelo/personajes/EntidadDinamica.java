package modelo.personajes;

import modelo.Mediador;
import modelo.Movimiento;
import modelo.Observador;
import modelo.decorador.ExtraVelocidad;
import modelo.estado.Estado;
import modelo.estado.EstadoReposo;
import modelo.estrategia.Mensaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class EntidadDinamica extends Entidad implements Observador{
	protected String tipoMovimiento = "";
	protected Estado estado;
	protected boolean animacionLoop;
	protected Animation  animIzquierda,animDerecha;
	protected Animation animExplosion;
	protected Movimiento movimiento;
	protected Mediador mediador;
	protected String canal;
	protected String[] canalesDeColision;
	public EntidadDinamica(TextureRegion _texturaNormal){
		super(_texturaNormal);
		estado = new EstadoReposo(this);
		movimiento= new Movimiento();
		animacionLoop = false;
		mediador = Mediador.getMediador();
	}

	public void eliminarColega(){
		mediador.eliminarColega(canal, this);
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
	public void registrarseEnElMediador(String _canal){
		mediador.registrarse(canal, this);
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
public void configurar(Vector2 parametros) {
		superficie = new Rectangle(parametros.x,parametros.y, getAncho(), getAlto());
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

public void actualiza(float time){
	float tiempoTranscurrido = Gdx.graphics.getDeltaTime();
	actualizar(tiempoTranscurrido);
}
public void actualiza(SpriteBatch batch){
	dibujar(batch);
}

public Mediador getMediador() {
	// TODO Auto-generated method stub
	return mediador;
}

public void eliminarSubscripcion() {
	Mensaje mensaje = new Mensaje();
	mensaje.setDescripcion(this);
	mensaje.setAsunto("SuprimirSubscripcion");
	mediador.enviar("Logica", mensaje);
}
public void enviarPuntos(){
	Mensaje mensajeParaLogica = new Mensaje();
	mensajeParaLogica.setAsunto("PuntosDelObjeto");
	mensajeParaLogica.setDescripcion(getPuntos());
	mediador.enviar("Logica", mensajeParaLogica);
}

public String getCanal() {
	// TODO Auto-generated method stub
	return canal;
}

public String[] getCanalesDeColision() {
	// TODO Auto-generated method stub
	return canalesDeColision;
}


}
