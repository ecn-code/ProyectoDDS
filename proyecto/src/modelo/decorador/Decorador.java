package modelo.decorador;

import modelo.personajes.EntidadDinamica;

public abstract class Decorador extends EntidadDinamica{
	public abstract float getVx();
	public abstract float getVy();
	public EntidadDinamica componente;
	public Decorador(EntidadDinamica _componente){
		super(_componente.getTexturaNormal());
		componente=_componente;
		textura=componente.getTextura();

		animDerecha=componente.getAnimDerecha();
		animExplosion=componente.getAnimExplosion();
		animIzquierda=componente.getAnimIzquierda();
		superficie=componente.getSuperficie();
	}
	
}
