 package controlador;

public class Invoker {
private Comando comando;
public Invoker(Comando _comando){
	comando=_comando;
}
public void ejecutar(){
	comando.ejecutar();
}
public boolean hayComando(){
	return comando!=null;
}
public void setComando(Comando _comando){
	comando=_comando;
}
}
