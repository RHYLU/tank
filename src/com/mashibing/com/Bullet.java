package com.mashibing.com;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int speed = 5;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	
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
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		}
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
