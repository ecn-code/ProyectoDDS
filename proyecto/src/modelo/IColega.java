package modelo;

import modelo.personajes.EntidadDinamica;

public interface IColega {
	public void recibir(Object objeto);
	public void enviar(EntidadDinamica entidad);
}
