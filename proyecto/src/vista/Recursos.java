package vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Recursos {
	public static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/imagenes.atlas"));
	public static AtlasRegion bala = atlas.findRegion("bala");
	public static  AtlasRegion balaEnemiga = atlas.findRegion("balaEnemiga2"); 
	public static  AtlasRegion mocoRojo1 = atlas.findRegion("mocoRojo1");
	public static  AtlasRegion mocoRojo2 = atlas.findRegion("mocoRojo2");
	public static  AtlasRegion naveNormal = atlas.findRegion("naveNormal");
	public static  AtlasRegion naveIzq1 = atlas.findRegion("naveIzq1");
	public static  AtlasRegion naveIzq2 = atlas.findRegion("naveIzq2");
	public static  AtlasRegion libelula1 = atlas.findRegion("libelula1");
	public static  AtlasRegion libelula2 = atlas.findRegion("libelula2");
	public static  AtlasRegion libelula3 = atlas.findRegion("libelula3");
	public static  AtlasRegion abeja1 = atlas.findRegion("abeja1");
	public static  AtlasRegion abeja2 = atlas.findRegion("abeja2");
	public static  AtlasRegion abeja3 = atlas.findRegion("abeja3");
	public static  AtlasRegion abeja4 = atlas.findRegion("abeja4");
	public static  AtlasRegion ciclope1 = atlas.findRegion("ciclope1");
	public static  AtlasRegion ciclope2 = atlas.findRegion("ciclope2");
	public static  AtlasRegion ciclope3 = atlas.findRegion("ciclope3");
	public static  AtlasRegion bolaVida = atlas.findRegion("bolaVerde");
	public static  AtlasRegion bolaVelocidad = atlas.findRegion("bolaVelocidad");
	public static Animation animAbeja = new Animation(0.2f, new AtlasRegion[] {abeja1, abeja2, abeja3, abeja4});
	public static Animation animLibelulaDerecha = new Animation(0.2f, new AtlasRegion[] {libelula1, libelula2, libelula3});
	public static Animation animLibelulaIzquierda = animLibelulaDerecha;
	public static Animation animBolaVidaDerecha = new Animation(0.2f, new AtlasRegion[] {bolaVida});
	public static Animation animBolaVidaIzquierda = animBolaVidaDerecha;
	public static Animation animBolaVelocidadDerecha = new Animation(0.2f, new AtlasRegion[] {bolaVelocidad});
	public static Animation animBolaVelocidadIzquierda = animBolaVelocidadDerecha;
	public static Animation animCiclopeDerecha = new Animation(0.2f, new AtlasRegion[] {ciclope1, ciclope2, ciclope3});
	public static Animation animCiclopeIzquierda = animCiclopeDerecha;
	public static Animation animMocoRojoDerecha = new Animation(0.2f, new AtlasRegion[] {mocoRojo1, mocoRojo2});
	public static Animation animMocoRojoIzquiera = animMocoRojoDerecha;
	public static  AtlasRegion fondo = atlas.findRegion("fondo");
	public static  AtlasRegion panelSuperior = atlas.findRegion("panelSuperior");
	public static  AtlasRegion nube1 = atlas.findRegion("fondoLargo");
	public static Sound sonidoDisparo= Gdx.audio.newSound(Gdx.files.internal("data/sonidoDisparo.mp3"));
	public static AtlasRegion titulo1 = atlas.findRegion("titulo1");
	public static AtlasRegion titulo2 = atlas.findRegion("titulo2");
	public static AtlasRegion elias = atlas.findRegion("elias");
	public static AtlasRegion enrique = atlas.findRegion("enrique");
	public static AtlasRegion roberto = atlas.findRegion("roberto");
	
	
	public static AtlasRegion explosionTextura =atlas.findRegion("explosion");
	public static TextureRegion explosion1 = new TextureRegion(explosionTextura,0,0,118,118);
	public static TextureRegion explosion2 = new TextureRegion(explosionTextura,118,0,118,118);
	public static TextureRegion explosion3 = new TextureRegion(explosionTextura,236,0,118,118);
	public static TextureRegion explosion4 = new TextureRegion(explosionTextura,354,0,118,118);
	public static TextureRegion explosion5 = new TextureRegion(explosionTextura,472,0,118,118);

	public static Animation animExplosion = new Animation(0.15f, new TextureRegion[] {explosion1,explosion2, explosion3, explosion4, explosion5});
	public static Animation animExplosionBala = new Animation(0.15f, new TextureRegion[] {explosion1});
	AtlasRegion te []= new AtlasRegion[] {naveNormal,naveIzq1,naveIzq2};

	public static Animation animNaveIzquierda = new Animation(0.2f, new AtlasRegion[] {naveNormal,naveIzq1,naveIzq2});

	public static  AtlasRegion naveDer1 = atlas.findRegion("naveDer1");
	public static  AtlasRegion naveDer2 = atlas.findRegion("naveDer2");
	public static  Animation animNaveDerecha = new Animation(0.2f, new AtlasRegion[] 
			{naveNormal,naveDer1,naveDer2});
	/**MARCADOR**/
	public static  AtlasRegion n1 = atlas.findRegion("1");
	public static  AtlasRegion n2 = atlas.findRegion("2");
	public static  AtlasRegion n3 = atlas.findRegion("3");
	public static  AtlasRegion n4 = atlas.findRegion("4");
	public static  AtlasRegion n5 = atlas.findRegion("5");
	public static  AtlasRegion n6 = atlas.findRegion("6");
	public static  AtlasRegion n7 = atlas.findRegion("7");
	public static  AtlasRegion n8 = atlas.findRegion("8");
	public static  AtlasRegion n9 = atlas.findRegion("9");
	public static  AtlasRegion n0 = atlas.findRegion("0");
	public static AtlasRegion marcadorTexturas []= new AtlasRegion[]
			{n0,n1,n2,n3,n4,n5,n6,n7,n8,n9};
	public static AtlasRegion jefeRajoy=atlas.findRegion("jefeRajoy");;
	public static Animation animJefeRajoyDerecha = new Animation(0.2f, new AtlasRegion[] {jefeRajoy});
	public static Animation animJefeRajoyIzquierda = animJefeRajoyDerecha;

/*public static  TextureRegion bala = new TextureRegion(new Texture(Gdx.files.internal("data/bala.png"))); 
public static  TextureRegion balaEnemiga = new TextureRegion(new Texture(Gdx.files.internal("data/balaEnemiga2.png"))); 
public static  TextureRegion mocoRojo1 = new TextureRegion(new Texture(Gdx.files.internal("data/mocoRojo1.png")));
public static  TextureRegion mocoRojo2 = new TextureRegion(new Texture(Gdx.files.internal("data/mocoRojo2.png")));
public static  TextureRegion naveNormal = new TextureRegion(new Texture(Gdx.files.internal("data/naveNormal.png")));
public static  TextureRegion naveIzq1 = new TextureRegion(new Texture(Gdx.files.internal("data/naveIzq1.png")));
public static  TextureRegion naveIzq2 = new TextureRegion(new Texture(Gdx.files.internal("data/naveIzq2.png")));
public static  TextureRegion libelula1 = new TextureRegion(new Texture(Gdx.files.internal("data/libelula1.png")));
public static  TextureRegion libelula2 = new TextureRegion(new Texture(Gdx.files.internal("data/libelula2.png")));
public static  TextureRegion libelula3 = new TextureRegion(new Texture(Gdx.files.internal("data/libelula3.png")));
public static  TextureRegion abeja1 = new TextureRegion(new Texture(Gdx.files.internal("data/abeja1.png")));
public static  TextureRegion abeja2 = new TextureRegion(new Texture(Gdx.files.internal("data/abeja2.png")));
public static  TextureRegion abeja3 = new TextureRegion(new Texture(Gdx.files.internal("data/abeja3.png")));
public static  TextureRegion abeja4 = new TextureRegion(new Texture(Gdx.files.internal("data/abeja4.png")));
public static  TextureRegion ciclope1 = new TextureRegion(new Texture(Gdx.files.internal("data/ciclope1.png")));
public static  TextureRegion ciclope2 = new TextureRegion(new Texture(Gdx.files.internal("data/ciclope2.png")));
public static  TextureRegion ciclope3 = new TextureRegion(new Texture(Gdx.files.internal("data/ciclope3.png")));
public static  TextureRegion bolaVida = new TextureRegion(new Texture(Gdx.files.internal("data/bolaVerde.png")));
public static  TextureRegion bolaVelocidad = new TextureRegion(new Texture(Gdx.files.internal("data/bolaVelocidad.png")));
public static Animation animAbeja = new Animation(0.2f, new TextureRegion[] {abeja1, abeja2, abeja3, abeja4});
public static Animation animLibelulaDerecha = new Animation(0.2f, new TextureRegion[] {libelula1, libelula2, libelula3});
public static Animation animLibelulaIzquierda = animLibelulaDerecha;
public static Animation animBolaVidaDerecha = new Animation(0.2f, new TextureRegion[] {bolaVida});
public static Animation animBolaVidaIzquierda = animBolaVidaDerecha;
public static Animation animBolaVelocidadDerecha = new Animation(0.2f, new TextureRegion[] {bolaVelocidad});
public static Animation animBolaVelocidadIzquierda = animBolaVelocidadDerecha;
public static Animation animCiclopeDerecha = new Animation(0.2f, new TextureRegion[] {ciclope1, ciclope2, ciclope3});
public static Animation animCiclopeIzquierda = animCiclopeDerecha;
public static Animation animMocoRojoDerecha = new Animation(0.2f, new TextureRegion[] {mocoRojo1, mocoRojo2});
public static Animation animMocoRojoIzquiera = animMocoRojoDerecha;
public static  TextureRegion fondo = new TextureRegion(new Texture(Gdx.files.internal("data/fondo.png")));
public static  TextureRegion panelSuperior = new TextureRegion(new Texture(Gdx.files.internal("data/panelSuperior.png")));
public static  TextureRegion nube1 = new TextureRegion(new Texture(Gdx.files.internal("data/fondoLargo.png")));
public static Sound sonidoDisparo= Gdx.audio.newSound(Gdx.files.internal("data/sonidoDisparo.mp3"));
public static Texture explosionTextura = new Texture(Gdx.files.internal("data/explosion.png"));
public static TextureRegion explosion1 = new TextureRegion(explosionTextura,0,0,118,118);
public static TextureRegion explosion2 = new TextureRegion(explosionTextura,118,0,118,118);
public static TextureRegion explosion3 = new TextureRegion(explosionTextura,236,0,118,118);
public static TextureRegion explosion4 = new TextureRegion(explosionTextura,354,0,118,118);
public static TextureRegion explosion5 = new TextureRegion(explosionTextura,472,0,118,118);

public static Animation animExplosion = new Animation(0.15f, new TextureRegion[] {explosion1,explosion2, explosion3, explosion4, explosion5});
public static Animation animExplosionBala = new Animation(0.15f, new TextureRegion[] {explosion1});
TextureRegion te []= new TextureRegion[] {naveNormal,naveIzq1,naveIzq2};

public static Animation animNaveIzquierda = new Animation(0.2f, new TextureRegion[] {naveNormal,naveIzq1,naveIzq2});

public static  TextureRegion naveDer1 = new TextureRegion(new Texture(Gdx.files.internal("data/naveDer1.png")));
public static  TextureRegion naveDer2 = new TextureRegion(new Texture(Gdx.files.internal("data/naveDer2.png")));
public static  Animation animNaveDerecha = new Animation(0.2f, new TextureRegion[] 
		{naveNormal,naveDer1,naveDer2});

public static  TextureRegion n1 = new TextureRegion(new Texture(Gdx.files.internal("data/1.png")));
public static  TextureRegion n2 = new TextureRegion(new Texture(Gdx.files.internal("data/2.png")));
public static  TextureRegion n3 = new TextureRegion(new Texture(Gdx.files.internal("data/3.png")));
public static  TextureRegion n4 = new TextureRegion(new Texture(Gdx.files.internal("data/4.png")));
public static  TextureRegion n5 = new TextureRegion(new Texture(Gdx.files.internal("data/5.png")));
public static  TextureRegion n6 = new TextureRegion(new Texture(Gdx.files.internal("data/6.png")));
public static  TextureRegion n7 = new TextureRegion(new Texture(Gdx.files.internal("data/7.png")));
public static  TextureRegion n8 = new TextureRegion(new Texture(Gdx.files.internal("data/8.png")));
public static  TextureRegion n9 = new TextureRegion(new Texture(Gdx.files.internal("data/9.png")));
public static  TextureRegion n0 = new TextureRegion(new Texture(Gdx.files.internal("data/0.png")));
public static TextureRegion marcadorTexturas []= new TextureRegion[]
		{n0,n1,n2,n3,n4,n5,n6,n7,n8,n9};
public static TextureRegion jefeRajoy=new TextureRegion(new Texture(Gdx.files.internal("data/jefeRajoy.png")));;
public static Animation animJefeRajoyDerecha = new Animation(0.2f, new TextureRegion[] {jefeRajoy});
public static Animation animJefeRajoyIzquierda = animJefeRajoyDerecha;


*/
}
