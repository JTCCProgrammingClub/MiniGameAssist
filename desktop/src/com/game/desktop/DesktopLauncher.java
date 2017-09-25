package com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import game.BasicGame;
import game.GameApp;
import game.GameMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		GameMain game = new GameMain();
		
		config.title = GameApp.settings.title;
		config.width = GameApp.settings.width;
		config.height = GameApp.settings.height;
		config.fullscreen = false;
		config.resizable = false;
		
		new LwjglApplication(game, config);
	}
}
