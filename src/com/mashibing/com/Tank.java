package com.mashibing.com;

import java.awt.Color;
import java.awt.Graphics;


public class Tank {

	private int x, y;//定义初始位置
	private static final int speed = 10; // 定义坦克速度
	Dir dir = Dir.UP; // 定义坦克初始方向
	private boolean moving = false;
	public TankFrame tFrame = null;
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tFrame = tankFrame;
	}

	public void paint(Graphics g) {

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
	}

	/*
	 * 发射子弹
	 */
	public void fire() {
		tFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tFrame));
	}

}
