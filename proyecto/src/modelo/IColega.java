package modelo;

import modelo.estrategia.IEstrategia;
import modelo.estrategia.Mensaje;
import modelo.personajes.EntidadDinamica;

public interface IColega {
	public void recibir(IEstrategia estrategia);
}
