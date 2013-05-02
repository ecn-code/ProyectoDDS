package modelo.estado;

public interface Estado {
public void actualizarTextura(float time);
public void mover(float vx);
public void colisionar();
}
