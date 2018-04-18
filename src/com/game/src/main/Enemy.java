package com.game.src.main;

import java.awt.Graphics;

import com.game.src.classes.EntityB;

public class Enemy extends GameObject implements EntityB {
	
	private Textures tex;
	
	public Enemy(double x, double y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}
	
	public void tick() {
		y += 2;
	}
	
	public void render (Graphics g) {
		g.drawImage(tex.enemy, (int)x, (int)y, null);
	}

	@Override
	public double getX() {
		
		return x;
	}

	@Override
	public double getY() {
		
		return y;
	}
}
