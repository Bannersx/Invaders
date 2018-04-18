package com.game.src.main;

import java.awt.Graphics;

import com.game.src.classes.EntityA;

public class Bullet extends GameObject implements EntityA{
	
	Textures tex;
	
	public Bullet(double x, double y, Textures tex) {
		super(x,y);
		this.tex = tex;
		
	}
	
	public void tick() {
		y -= 10;
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.missile,(int) x, (int)y, null);
	}
	public double getY() {
		return y;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
}
