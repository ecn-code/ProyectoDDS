package modelo;

import modelo.estrategia.Mensaje;

public interface IMediador {
	public void registrarse(String canal,IColega colega);
public void enviar(String _canal,Mensaje _mensaje);
public void eliminarColega(String canal,IColega _colega);
}