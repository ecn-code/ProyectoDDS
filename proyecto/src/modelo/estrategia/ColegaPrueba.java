package modelo.estrategia;

import modelo.IColega;
import modelo.IMediador;

public class ColegaPrueba implements IColega {
	IMediador mediador;
	public ColegaPrueba(IMediador _mediador){
		mediador = _mediador;
	}

	@Override
	public void recibir(IEstrategia estrategia) {
		estrategia.comportamiento();
	}
	
	public void enviar(String _canal,Mensaje _mensaje){
		mediador.enviar(_canal, _mensaje);
	}
	
	public void saludar(){
		System.out.println("Soy colega");
	}

}
