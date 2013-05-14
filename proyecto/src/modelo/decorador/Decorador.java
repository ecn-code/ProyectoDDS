package modelo.decorador;

import modelo.personajes.EntidadDinamica;

public abstract class Decorador extends EntidadDinamica{
	public abstract float getVx();
	public abstract float getVy();
	EntidadDinamica componente;
	public Decorador(EntidadDinamica _componente){
		super(_componente.getTexturaNormal());
		System.out.println("decorado");
		componente=_componente;
		textura=componente.getTextura();

		movimiento=componente.getMovimiento();
		animDerecha=componente.getAnimDerecha();
		animExplosion=componente.getAnimExplosion();
		animIzquierda=componente.getAnimIzquierda();
		superficie=componente.getSuperficie();
	}
	
}
