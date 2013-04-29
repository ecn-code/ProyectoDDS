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
