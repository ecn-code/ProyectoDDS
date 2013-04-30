package modelo;

public class Reloj {
	
	private float acumulado;
	
	public Reloj(){
		acumulado = 0;
	}
	
	public void actualizar(float time){
		acumulado += time;
	}
	
	public void reset(){
		acumulado = 0;
	}
	
	public float getAcumulado(){
		return acumulado;
	}

}
