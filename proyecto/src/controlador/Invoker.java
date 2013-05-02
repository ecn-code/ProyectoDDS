 package controlador;

import java.util.ArrayList;

public class Invoker {
private ArrayList<Comando> comando;
public Invoker(Comando _comando){
	comando = new ArrayList<Comando>();
	if(_comando!=null)
	comando.add(_comando);
}
public void ejecutar(){
	comando.remove(0).ejecutar();
	}
public boolean hayComando(){
	return comando.size()>0;
}
public void setComando(Comando _comando){
	comando.add(_comando);
}
}
