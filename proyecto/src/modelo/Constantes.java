package modelo;

import com.badlogic.gdx.Gdx;

public class Constantes {
	public static final float[] movimientoCuadrado = new float[]{
		100,0,100,0,
		0,-200,0,160,
		-100,0,100,0,
		0,100,0,100
		
}; 
	public static final float[] movimientoRajoy = new float[]{
		0,-20,0,100,
		-100,-100,300,50,
		100,100,100,200,
		0,-400,0,120,
		100,100,50,160
};
	public static final float tiempoRefrescoMapa=3;
	public static final int filasPantalla = 3;
	public static final int ColumnasPantalla = 15;
	public static final float columnaCalculada = Gdx.graphics.getWidth()/ColumnasPantalla;
	public static final float filaCalculada = Gdx.graphics.getHeight()/filasPantalla;
	public static final int numeroCifrasMarcador = 6;
	public static final float velocidadNave=100;
	public static final float velocidadMocoRojo=100;
	public static final float velocidadLibelula=200;
	public static final float velocidadAveja=100;
	public static final float velocidadBala=450;
	public static final float velocidadBalaEnemigo=300;
	public static final float velocidadJefeRajoy=100;
	public static final float velocidadCiclope=50;
	public static final float velocidadBolaVida=50;
	public static final float velocidadBolaVelocidad=50;
	public static final int velocidadFondo = 50;
	public static final float[] movimientoAbeja=new float[]{
		0,-120,0,50,
		-100,-50,100,50,
};

}
