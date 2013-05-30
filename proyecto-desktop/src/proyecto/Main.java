package proyecto;

import vista.Proyecto;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "proyecto";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 600;
	   /* Settings settings = new Settings();
        settings.maxWidth = 4096;
        settings.maxHeight = 4096;
        TexturePacker2.process(settings, "../proyecto-android/assets/data", "../proyecto-android/assets/data", "imagenes");
		*/new LwjglApplication(new Proyecto(), cfg);
	}
}
