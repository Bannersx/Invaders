package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
		public static final int WIDTH = 320;
		public static final int HEIGHT = WIDTH / 12 *9;
		public static final int SCALE = 2;
		public static String TITLE = "SPACE INVADERS";
		
		private boolean running = false;
		private Thread thread;
		
		private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		private BufferedImage spriteSheet = null;
		private BufferedImage background = null;
		private BufferedImage bg = null;
		
		private boolean is_shooting = false;
		
		private Player player;
		private ControllerT c;
		private Textures tex;
		
		public void init() {
			requestFocus();
			BufferedImageLoader loader = new BufferedImageLoader();
			try {
				
				spriteSheet = loader.loadImage("/sprite_sheet.png");
				background = loader.loadImage("/backgroud.png");
				bg = loader.loadImage("/Background.png");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			addKeyListener(new KeyInput(this));
			
			tex = new Textures(this);
			
			player = new Player(300, 420, tex);
			c = new ControllerT(this, tex);
			
			c.createEnemy(5);
			
		}
		
		
		private synchronized void start() {  //Evita multithreading
			if (running) 
				return;
			
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
		private synchronized void stop() {
			if (!running)
				return;
			
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(1);
		}
		
		public void run() {
			init();
			long lastTime = System.nanoTime();
			final double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			int updates = 0;
			int frames = 0;
			long timer = System.currentTimeMillis();			
			
			while(running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				if (delta >= 1 ) {
					tick();
					updates++;
					delta--;
				}
			render();	
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + "Tick, FPS" + frames);
				updates = 0;
				frames = 0;
				
			}
			
			}
			stop();
		}
		
		
		private void tick() {
			// TODO Auto-generated method stub
			player.tick();
			c.tick();
			
		}
		
		private void render() {
			
			BufferStrategy bs = this.getBufferStrategy();
			
			if (bs == null) {
				
				createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			///////////////////////////////////Drawing space////
			
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			
			g.drawImage(bg, 0, 0, null);
			g.drawImage(background, 0, 0, null);
			
			player.render(g);
			c.render(g);

			
			///////////////////////////////////
			g.dispose();
			bs.show();
			
		}
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key== KeyEvent.VK_D) {
				player.setVelX(5);
			}else if (key== KeyEvent.VK_A) {
				player.setVelX(-5);
			}else if (key == KeyEvent.VK_SPACE && !is_shooting) {
				is_shooting = true;
				c.addBullet(new Bullet(player.getX(),player.getY(),tex));
			}
		} 

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key== KeyEvent.VK_D) {
				player.setVelX(0);
			}else if (key== KeyEvent.VK_A) {
				player.setVelX(0);
			}else if (key == KeyEvent.VK_SPACE) {
				is_shooting = false;
			}
		}

		public static void main(String args[]) {
			
			Game game = new Game();
			
			
			game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			
			JFrame frame = new JFrame(game.TITLE);
			frame.add(game);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			game.start();
			

		}
		
		public BufferedImage getSpriteSheet() {
				return spriteSheet;
		}

}
