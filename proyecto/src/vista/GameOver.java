package vista;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen {
SpriteBatch batch;
Texture intro;
Game game;
BitmapFont font;
int puntos=0;
	public GameOver(Game _game,int _puntos) {
		batch = new SpriteBatch();
		intro = new Texture(Gdx.files.internal("data/game-over.png"));
		Gdx.input.setInputProcessor(null);
		game = _game;
		puntos = _puntos;
		font = new BitmapFont();
		font.scale(3);
	}

	@Override
	public void render(float delta) {
		font.setColor(1f, 1f, 1f, 1f);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Keys.ALT_LEFT)) game.setScreen(new JuegoScreen(game));
		batch.begin();
		batch.draw(intro,195,380, 399, 48);
		font.draw(batch, puntos+" puntos", 250, 300);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
