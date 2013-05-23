package modelo.estrategia;

import modelo.IColega;

import com.badlogic.gdx.math.Rectangle;

public class Mensaje {
private IColega destinatario;
private String canalEmisor;
private String asunto;
private Object descripcion;
public String getAsunto() {
	return asunto;
}

public void setAsunto(String asunto) {
	this.asunto = asunto;
}



public Object getDestinatario() {
	return destinatario;
}

public void setDestinatario(IColega destinatario) {
	this.destinatario = destinatario;
}

public Object getDescripcion() {
	return descripcion;
}

public void setDescripcion(Object superficie) {
	this.descripcion = superficie;
}

public String getCanalEmisor() {
	return canalEmisor;
}

public void setCanalEmisor(String canalEmisor) {
	this.canalEmisor = canalEmisor;
}


}
