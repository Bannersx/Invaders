package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures {
	
	public BufferedImage player, missile, enemy, boss;
	
	private SpriteSheet ss;
	
	public Textures(Game game) {
	  ss = new SpriteSheet(game.getSpriteSheet());
	  
	  getTextures();
	}
	
	private void getTextures() {
		player = ss.grabImage(1, 1, 32, 32);
		missile = ss.grabImage(1, 2, 32, 32);
		enemy = ss.grabImage(2, 1, 32, 32);
		boss = ss.grabImage(4, 1, 32, 32);
	}

}
