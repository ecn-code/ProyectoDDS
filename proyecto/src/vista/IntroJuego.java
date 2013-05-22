package vista;

import modelo.Reloj;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IntroJuego implements Screen{
	SpriteBatch batch;
	Texture titulo1,nave,naveNormal,titulo2,elias,enrique,roberto,libelula,mocoRojo,ciclope,abeja,bala;
	Game game;
	private float xTitulo1=-400;
	private float xTitulo2=810;
	private int xNave=-200;
	private int yEnrique=700;
	private float xElias=-200;
	private float xRoberto=-200;
	private float xMocoRojo=-1100;
	private float xCiclope=-1500;
	private float xLibelula=-650;
	private float xAbeja=-100;
	private float yBala=110;
	boolean entraNave=false;
	boolean entranNombres=false;
	boolean entranEnemigos=false;
	boolean empiezaJuego=false;
	
	Reloj reloj;
	Music music; 

	public IntroJuego(Game _game){
		batch = new SpriteBatch();
		titulo1 = new Texture(Gdx.files.internal("data/titulo1.png"));
		titulo2 = new Texture(Gdx.files.internal("data/titulo2.png"));
		nave = new Texture(Gdx.files.internal("data/naveDer1.png"));
		elias = new Texture(Gdx.files.internal("data/elias.png"));
		enrique = new Texture(Gdx.files.internal("data/enrique.png"));
		roberto = new Texture(Gdx.files.internal("data/roberto.png"));
		naveNormal = new Texture(Gdx.files.internal("data/naveNormal.png"));
		libelula = new Texture(Gdx.files.internal("data/libelula1.png"));
		mocoRojo = new Texture(Gdx.files.internal("data/mocoRojo1.png"));
		ciclope = new Texture(Gdx.files.internal("data/ciclope1.png"));
		abeja = new Texture(Gdx.files.internal("data/abeja1.png"));
		bala = new Texture(Gdx.files.internal("data/bala.png"));
		reloj=new Reloj();
		reloj.reset();
		game = _game;
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("data/entrada1.mp3", FileType.Internal));
		music.setVolume(0.5f);
		music.play();

	}
	@Override
	public void render(float delta) {
		reloj.actualizar(delta);
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(titulo1,xTitulo1,450,375,75);
		batch.draw(titulo2,xTitulo2,400,375,75);
		//if(reloj.getAcumulado()>0.2){
			if(xTitulo1<180){
				xTitulo1=xTitulo1+2.5f;
			}else{
				entranNombres=true;
			}
			if(xTitulo2>310){
				xTitulo2=xTitulo2-2.5f;
			}
		
		if(entraNave && xNave<350){
			batch.draw(nave,xNave,50);
			xNave=xNave+2;
		}else{
			batch.draw(naveNormal,xNave,50);	
		}
		if(entranNombres && yEnrique>55){
			batch.draw(enrique,620,yEnrique,150,30);
			yEnrique=yEnrique-2;
		}else{
			batch.draw(enrique,620,yEnrique,150,30);
		}
		if(entranNombres && xElias<620){
			batch.draw(elias,xElias,85,150,30);
			xElias=xElias+2.25f;
		}else{
			batch.draw(elias,xElias,85,150,30);
		}
		if(entranNombres && xRoberto<620){
			batch.draw(roberto,xRoberto,25,150,30);
			xRoberto=xRoberto+2.25f;
			
		}else{
			batch.draw(roberto,xRoberto,25,150,30);
			
		}
		if(xRoberto>618){
			entranEnemigos=true;
		}
		if(entranEnemigos==true){
			batch.draw(abeja,xAbeja,300,50,50);
			batch.draw(libelula,xLibelula,250,50,50);
			batch.draw(mocoRojo,xMocoRojo,300,50,50);
			batch.draw(ciclope,xCiclope,250,50,50);
			if(xAbeja<475)
				xAbeja+=1.75f;
			if(xLibelula<400)
				xLibelula+=1.75f;
			if(xMocoRojo<325)
				xMocoRojo+=1.75f;
			if(xCiclope<250)
				xCiclope+=1.75f;
		}
		if(xCiclope==250){
			entraNave=true;
		}
		if(xNave==350){
			batch.draw(bala,xNave+20,yBala,25,25);
			yBala=yBala+1;
			empiezaJuego=true;
		}
		//}
			if(yBala>200 && empiezaJuego){
				game.setScreen(new JuegoScreen(game));
			}
		
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
