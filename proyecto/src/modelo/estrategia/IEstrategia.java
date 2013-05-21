package modelo.estrategia;

public abstract class IEstrategia{
	Mensaje mensaje;
public IEstrategia(Mensaje _mensaje) {
	mensaje = _mensaje;
}
public abstract void comportamiento();
}
