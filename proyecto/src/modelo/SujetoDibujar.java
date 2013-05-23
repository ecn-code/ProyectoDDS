package modelo;

import modelo.estrategia.IEstrategia;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SujetoDibujar extends Sujeto implements IColega{
private SpriteBatch batch;
public SujetoDibujar(SpriteBatch _batch){
	super();
	batch = _batch;
}
public SpriteBatch getBatch(){
	return batch;
}
@Override
public void recibir(IEstrategia estrategia) {
	estrategia.comportamiento();
}
}
