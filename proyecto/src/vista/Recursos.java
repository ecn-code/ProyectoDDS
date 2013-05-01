package vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Recursos {
	public static  TextureRegion bala = new TextureRegion(new Texture(Gdx.files.internal("data/bala.png")));
public static  TextureRegion mocoRojo = new TextureRegion(new Texture(Gdx.files.internal("data/mocoRojo.png")));
public static  TextureRegion naveNormal = new TextureRegion(new Texture(Gdx.files.internal("data/naveNormal.png")));
public static  TextureRegion naveIzq1 = new TextureRegion(new Texture(Gdx.files.internal("data/naveIzq1.png")));
public static  TextureRegion naveIzq2 = new TextureRegion(new Texture(Gdx.files.internal("data/naveIzq2.png")));
public static  TextureRegion libelula = new TextureRegion(new Texture(Gdx.files.internal("data/libelula.png")));
public static  TextureRegion fondo = new TextureRegion(new Texture(Gdx.files.internal("data/fondo.png")));
public static Texture explosionTextura = new Texture(Gdx.files.internal("data/explosion.png"));
public static TextureRegion explosion1 = new TextureRegion(explosionTextura,0,0,118,118);
public static TextureRegion explosion2 = new TextureRegion(explosionTextura,118,0,118,118);
public static Animation animExplosion = new Animation(0.2f, new TextureRegion[] {explosion1,explosion2});
TextureRegion te []= new TextureRegion[] {naveNormal,naveIzq1,naveIzq2};
public static  TextureRegion naveDer1 = new TextureRegion(naveIzq1);
public static  TextureRegion naveDer2 = new TextureRegion(naveIzq2);
public static  Animation animNaveDerecha;
public static Animation animNaveIzquierda = new Animation(0.2f, new TextureRegion[] {naveNormal,naveIzq1,naveIzq2});
public static void girar(){
	naveDer1.flip(true, false);
	naveDer2.flip(true, false);
	animNaveDerecha = new Animation(0.2f, new TextureRegion[] 
			{naveNormal,naveDer1,naveDer2});
}
}
