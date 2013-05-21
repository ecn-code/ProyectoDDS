package modelo;

import modelo.personajes.EntidadDinamica;

public interface IMediador {
public abstract void registrarse(String canal,Object objeto);
public abstract void enviar();
public abstract void eliminarColega(String canal,Object objeto);
}
