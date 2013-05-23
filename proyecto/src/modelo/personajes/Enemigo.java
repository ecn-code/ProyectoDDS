package modelo.personajes;

import modelo.Constantes;
import modelo.estrategia.Mensaje;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

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

public boolean disparo(){
	return Math.random()*10+Math.random()*3<1;
}
public void actualizar(float time){
	super.actualizar(time);
	if(movimientos!=null){
	movimientos[posMovimiento+2]-=Math.abs(getVx()*time);
	movimientos[posMovimiento+3]-=Math.abs(getVy()*time);
	}
	if(!explosiona && disparo()){
	Mensaje mensaje = new Mensaje();
	mensaje.setDescripcion(this.getSuperficie());
	mensaje.setAsunto("DisparoEnemigo");
	
	Vector2 parametros = new Vector2();
	parametros.x = getX()+getAncho()/2-10;
	parametros.y = getY();
	
	mensaje.setDescripcion(parametros);
	mediador.enviar("Logica", mensaje);
	}
	ejecutarMovimiento();
	}

private void ejecutarMovimiento() {
	if(movimientos!=null && 
			posMovimiento<movimientos.length){
	if(movimientos[posMovimiento+2]<=0 &&
			movimientos[posMovimiento+3]<=0){
		posMovimiento=posMovimiento+4;
		if(posMovimiento>=movimientos.length){
			posMovimiento=0;
		resetMovimientos();
		}
	setVx(movimientos[posMovimiento]);
	setVy(movimientos[posMovimiento+1]);
	}
	}
}

}
