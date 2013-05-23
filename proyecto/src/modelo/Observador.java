package modelo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Observador {
	void actualiza(float time);
	void actualiza(SpriteBatch batch);
}
