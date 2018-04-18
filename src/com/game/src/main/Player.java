package com.game.src.main;

import java.awt.Graphics;

import com.game.src.classes.EntityA;



public class Player extends GameObject implements EntityA	{
	
	private double velX = 0;
	
	private Textures tex;
	
	public Player(double x, double y, Textures tex) {
		super(x,y);
		this.tex = tex;
		
	}
	
	public void tick() {
		x += velX;
		
		if (x <= 0)
			x = 0;
		if (x >= 640 - 16)
			x = 640 - 16;
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.player, (int)x, (int)y, null);
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}

	
}
