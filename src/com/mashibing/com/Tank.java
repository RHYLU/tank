package com.mashibing.com;

import static org.junit.Assert.assertFalse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Tank {

	private int x, y;//定义初始位置
	Random random = new Random();
	private static final int speed = 10; // 定义坦克速度
	Dir dir = Dir.UP; // 定义坦克初始方向
	private boolean moving = true;
	public TankFrame tFrame = null;
	public static int WIDTH = ResourceMgr.tankD.getWidth();
	public static int HEIGHT = ResourceMgr.tankD.getHeight();
	private boolean living = true;
	private Group group = Group.BAD;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Tank(int x, int y, Dir dir,Group group, TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tFrame = tankFrame;
	}

	public void paint(Graphics g) {

		if(!living) tFrame.enemyList.remove(this);
		Color color = g.getColor();
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			break;
		}
		//System.out.println(x+"   "+y);
		move();
	}

	private void move() {
		if(!moving) return;
		
		switch (dir) {
		case LEFT:
			if(x-speed<0) {
				break;
			}else {
				x -= speed;
				break;
			}
		case RIGHT:
			if (x+speed>TankFrame.GAME_WIDTH) {
				break;
			} else {
				x += speed;
				break;
			}
		case UP:
			if (y-speed<0) {
				break;
			} else {
				y -= speed;
				break;
			}
		case DOWN:
			if (y+speed>TankFrame.GAME_HEIGHT) {
				break;
			} else {
				y += speed;
				break;
			}
		}
		if (random.nextInt(10)>5) {
			this.fire();
		}
	}

	/*
	 * 发射子弹
	 */
	public void fire() {
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 -Bullet.HEIGHT/2; 
//		int bX=0,bY=0;
//		switch (dir) {
//		case LEFT:
//			bX = this.x-Tank.WIDTH/2+Bullet.WIDTH/2;
//			bY = this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
//			break;
//		case RIGHT:
//			bX = this.x +Tank.WIDTH;
//			bY = this.y +Tank.HEIGHT/2-Bullet.HEIGHT/2;
//			break;
//		case UP:
//			bX = this.x + Tank.WIDTH/2-Bullet.HEIGHT/2;
//			bY = this.y;
//			break;
//		case DOWN:
//			bX = this.x+Tank.WIDTH/2-Bullet.HEIGHT/2;
//			bY = this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
//			break;
//		}
		tFrame.bullets.add(new Bullet(bX, bY, this.dir,this.group,this.tFrame));
	}

	public void die() {

		this.living = false;
	}

}
