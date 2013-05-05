package vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameWin implements Screen {
	SpriteBatch batch;
	Texture intro;
		public GameWin() {
			batch = new SpriteBatch();
			intro = new Texture(Gdx.files.internal("data/You Win.jpg"));
		}

		@Override
		public void render(float delta) {
			Gdx.gl.glClearColor(0, 1, 0, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
			batch.begin();
			batch.draw(intro,120,120);
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
