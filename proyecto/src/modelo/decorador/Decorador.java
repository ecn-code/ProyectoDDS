package modelo.decorador;

import com.badlogic.gdx.Gdx;

import modelo.estado.Estado;
import modelo.estrategia.Mensaje;
import modelo.personajes.Entidad;
import modelo.personajes.EntidadDinamica;

public abstract class Decorador extends EntidadDinamica{
	public abstract float getVx();
	public abstract float getVy();
	public abstract int getVida();
	public EntidadDinamica componente;
	public Decorador(EntidadDinamica _componente){
		super(_componente.getTexturaNormal());
		componente=_componente;
		textura=componente.getTextura();
		animDerecha=componente.getAnimDerecha();
		animExplosion=componente.getAnimExplosion();
		animIzquierda=componente.getAnimIzquierda();
		superficie=componente.getSuperficie();
		mediador = componente.getMediador();
		canal=componente.getCanal();
		canalesDeColision=componente.getCanalesDeColision();
	}
	@Override
	public void actualizar(float time){
		// TODO Auto-generated method stub 
	if(!(superficie.getX()+getVx()*time>0 && superficie.getX()+superficie.getWidth()+getVx()*time<Gdx.graphics.getWidth()))
		setVx(0);
	if(!(getY()+getVy()*time>0 && superficie.getY()+superficie.getHeight()+getVy()*time<Gdx.graphics.getHeight()))
		setVy(0);
		
super.actualizar(time);

Mensaje mensaje = new Mensaje();
mensaje.setDescripcion(this.getSuperficie());
mensaje.setAsunto("ComprobarColision");
mensaje.setCanalEmisor(canal);
for(String _canal : canalesDeColision)
mediador.enviar(_canal, mensaje);
	}
	
	@Override
	public void setVida(int _vida) {
		// TODO Auto-generated method stub
		componente.setVida(_vida);
	}
	@Override
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public void setVx(float _vx){
		componente.setVx(_vx);
	}
	@Override
	public void setVy(float _vy){
		componente.setVy(_vy);
	}
	@Override
	public Estado getEstado() {
		return this.estado ;
	}

}
