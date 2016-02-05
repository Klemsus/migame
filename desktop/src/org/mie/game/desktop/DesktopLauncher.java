package org.mie.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.mie.game.MIGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Misterious Island: Escape";
                config.width = 1024;
                config.height = 600;
		new LwjglApplication(new MIGame(), config);
	}
}
