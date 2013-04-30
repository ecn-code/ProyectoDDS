package modelo;

public interface Estado {
public void parar();
public void girarDerecha(float time);
public void girarIzquierda(float time);
public void colisionar(float time);
}
