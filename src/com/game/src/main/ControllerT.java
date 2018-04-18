package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.src.classes.EntityA;
import com.game.src.classes.EntityB;

public class ControllerT {
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	
	EntityA enta;
	EntityB entb;
	
	
	Game game;
	Textures tex;
	
	public ControllerT(Game game, Textures tex) {
		this.game = game;
		this.tex = tex;
			
	}
	
	public void createEnemy(int size) {
		int x = 200;
		for (int i = 0; i < 5; i++) {
			addEnemy(new Enemy(x,0,tex));
			x += 50;
		}
	}
	public void tick() {
		//A CLASS
		for (int i = 0; i < ea.size(); i++) {
			enta = ea.get(i);
			
			if(enta.getY() < 0 )
				removeEntityA(enta);
			
			enta.tick();
		}
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			
			TempEnemy.tick();
		}
	}
	
	public void render (Graphics g) {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);
			
			TempBullet.render(g);
		}
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			
			TempEnemy.render(g);
		}
	}
	public void addBullet(Bullet block) {
		b.add(block);
	}
	public void removeBullet(Bullet block) {
		b.remove(block);
	}
	public void addEnemy(Enemy block) {
		e.add(block);
	}
	public void removeEnemy(Enemy block) {
		e.remove(block);
	}
}
