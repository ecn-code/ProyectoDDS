package modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Nave extends EntidadDinamica {
	Estado EstadoIzquierda,EstadoDerecha, EstadoReposo, EstadoExplosion,estado;
public Nave(float x,float y,float ancho,float alto, float vx, float vy,AtlasRegion textura){
	super(x,y,ancho,alto,vx,vy,textura);
	EstadoIzquierda=new EstadoIzquierda(this);
	EstadoDerecha=new EstadoDerecha(this);
	EstadoReposo=new EstadoReposo(this);
	EstadoExplosion=new EstadoExplosion(this);
	estado=EstadoReposo;
}

public Estado getEstadoIzquierda() {
	return EstadoIzquierda;
}

public Estado getEstadoDerecha() {
	return EstadoDerecha;
}

public Estado getEstadoReposo() {
	return EstadoReposo;
}

public Estado getEstadoExplosion() {
	return EstadoExplosion;
}

public Estado getEstado() {
	return estado;
}

public void setEstado(Estado estado) {
	this.estado = estado;
}

@Override
	public void actualizar(float time) {
		// TODO Auto-generated method stub
	if(!(superficie.getX()+vx>0 && superficie.getX()+superficie.getWidth()+vx<Gdx.graphics.getWidth()))
		vx=0;
	if(!(superficie.getY()+vy>0 && superficie.getY()+superficie.getHeight()+vy<Gdx.graphics.getHeight()))
		vy=0;
		super.actualizar(time);
	}
public void parar(AtlasRegion _textura){
	estado.parar(_textura);
}
public void girarDerecha(AtlasRegion _textura){
	estado.girarDerecha(_textura);
}
public void girarIzquierda(AtlasRegion _textura){
	estado.girarIzquierda(_textura);
}
public void colisionar(AtlasRegion _textura){
	estado.colisionar(_textura);
}
}