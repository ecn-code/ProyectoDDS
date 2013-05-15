package vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Recursos {
	public static  TextureRegion bala = new TextureRegion(new Texture(Gdx.files.internal("data/bala.png"))); 
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
public static Animation animAbeja = new Animation(0.2f, new TextureRegion[] {abeja1, abeja2, abeja3, abeja4});
public static Animation animLibelulaDerecha = new Animation(0.2f, new TextureRegion[] {libelula1, libelula2, libelula3});
public static Animation animLibelulaIzquierda = animLibelulaDerecha;
public static Animation animBolaVidaDerecha = new Animation(0.2f, new TextureRegion[] {bolaVida});
public static Animation animBolaVidaIzquierda = animBolaVidaDerecha;
public static Animation animCiclopeDerecha = new Animation(0.2f, new TextureRegion[] {ciclope1, ciclope2, ciclope3});
public static Animation animCiclopeIzquierda = animCiclopeDerecha;
public static Animation animMocoRojoDerecha = new Animation(0.2f, new TextureRegion[] {mocoRojo1, mocoRojo2});
public static Animation animMocoRojoIzquiera = animMocoRojoDerecha;
public static  TextureRegion fondo = new TextureRegion(new Texture(Gdx.files.internal("data/fondo.png")));
public static  TextureRegion panelSuperior = new TextureRegion(new Texture(Gdx.files.internal("data/panelSuperior.png")));
public static  TextureRegion nube1 = new TextureRegion(new Texture(Gdx.files.internal("data/nube1.png")));
public static Sound sonidoDisparo= Gdx.audio.newSound(Gdx.files.internal("data/sonidoDisparo.mp3"));
public static Texture explosionTextura = new Texture(Gdx.files.internal("data/explosion.png"));
public static TextureRegion explosion1 = new TextureRegion(explosionTextura,0,0,118,118);
public static TextureRegion explosion2 = new TextureRegion(explosionTextura,118,0,118,118);
public static Animation animExplosion = new Animation(0.2f, new TextureRegion[] {explosion1,explosion2});
TextureRegion te []= new TextureRegion[] {naveNormal,naveIzq1,naveIzq2};

public static Animation animNaveIzquierda = new Animation(0.2f, new TextureRegion[] {naveNormal,naveIzq1,naveIzq2});

public static  TextureRegion naveDer1 = new TextureRegion(new Texture(Gdx.files.internal("data/naveDer1.png")));
public static  TextureRegion naveDer2 = new TextureRegion(new Texture(Gdx.files.internal("data/naveDer2.png")));
public static  Animation animNaveDerecha = new Animation(0.2f, new TextureRegion[] 
		{naveNormal,naveDer1,naveDer2});
/**MARCADOR**/
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




}
