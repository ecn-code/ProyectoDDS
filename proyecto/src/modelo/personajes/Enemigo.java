package modelo.personajes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Enemigo extends EntidadDinamica {
	public float movimientos[];
	public int posMovimiento;

	public Enemigo(TextureRegion bala) {
		super(bala);
		animacionLoop = true;
		posMovimiento=1;
		movimientos=new float[0];
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


}
