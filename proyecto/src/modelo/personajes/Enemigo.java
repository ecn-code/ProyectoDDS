package modelo.personajes;

import modelo.Constantes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Enemigo extends EntidadDinamica {
	public float movimientos[];
	public int posMovimiento;

	public Enemigo(TextureRegion bala) {
		super(bala);
		animacionLoop = true;
		posMovimiento=1;
		movimientos=null;
	}
public void resetMovimientos() {
movimientos=Constantes.movimientoCuadrado.clone();		
}
	public boolean colision(Amigo _amigo){
		return superficie.overlaps(_amigo.getSuperficie());
	}
	
public boolean colision(Entidad _entidad){
	if(_entidad instanceof Amigo) return colision((Amigo)_entidad);
		return false;
	}
public boolean disparo(){
	return Math.random()*10+Math.random()*3<1;
}
public void actualizar(float time){
	super.actualizar(time);
	if(movimientos!=null){
	movimientos[posMovimiento+2]-=Math.abs(getVx()*time);
	movimientos[posMovimiento+3]-=Math.abs(getVy()*time);
	}
	}

}
