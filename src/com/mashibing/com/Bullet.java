package com.mashibing.com;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int speed = 5;
	private static int WIDTH = 15, HEIGHT = 15;
	private int x, y;
	private Dir dir;
	private boolean live = true;
	TankFrame tFrame = null;

	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tFrame = tf;
	}

	public void paint(Graphics g) {

	if (!live) {
		tFrame.bullets.remove(this);
		}

		Color color = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		move();
	}
	
	private void move() {

		switch (dir) {
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;
		}
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
			live = false;
		
	}
}
