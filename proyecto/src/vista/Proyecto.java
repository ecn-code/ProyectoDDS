package vista;

import java.util.ArrayList;

import modelo.Bala;
import modelo.Enemigo;
import modelo.Entidad;
import modelo.EntidadDinamica;
import modelo.FabricaEntidadesDinamicas;
import modelo.InterfazFabrica;
import modelo.Logica;
import modelo.Personaje;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

import controlador.EventosTeclado;

public class Proyecto implements ApplicationListener {
	private SpriteBatch batch;
	private Texture texture;
	TextureRegion textura;
	private ArrayList<Entidad> array = new ArrayList<Entidad>();
	private EntidadDinamica nave;
	@Override
	public void create() {		
		
	/*	float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		*/
		Gdx.input.setInputProcessor(new EventosTeclado(new Logica(this)));
		InterfazFabrica fabrica = new FabricaEntidadesDinamicas();
		
		batch = new SpriteBatch();
		Rectangle rec = new Rectangle(0,0,10,10);
		Rectangle rec2 = new Rectangle(9,9,10,10);
		texture = new Texture(Gdx.files.internal("data/enemy.png"));
		textura = new TextureRegion(texture);
		nave=(EntidadDinamica) fabrica.crearEntidad("Personaje", new float[]{0,0,50,50,0,0},textura);
		array.add(nave);
		Entidad enemigo = fabrica.crearEntidad("Enemigo",new float[]{0,0,50,50,0,0},textura);		
		array.add(enemigo);
		Entidad bala = fabrica.crearEntidad("Bala",new float[]{20,40,150,50,0.2f,0},textura);
		array.add(bala);
		//Entidad personaje = fabrica.crearEntidad("Personaje",new float[]{270,70,200,50,4,4},textura);
		//array.add(personaje);
		System.out.println("Contiene?");
	}
	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		for(Entidad entidad : array)
		batch.draw(entidad.getTextura(), entidad.getX(), 
				entidad.getY(), entidad.getAncho(), entidad.getAlto());
		batch.end();
		
		for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(5f);
		
		for(int r=0;array.size()>r;r++) 
			for(int i=0;array.size()>i;i++)
			if(array.get(i)!=array.get(r))
			if(array.get(r).colision(array.get(i).getSuperficie()))
				System.out.println("Si");
			else
				System.out.println("No");
	}
	public void moverPersonajeX(float vx){
		nave.setVx(vx);
	}
	public void moverPersonajeY(float vy){
		nave.setVy(vy);
	}
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
