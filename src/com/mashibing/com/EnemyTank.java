package com.mashibing.com;

import java.util.Random;

import com.sun.jdi.Value;

public class EnemyTank extends Tank{

	private int x,y;
	final private int speed = 100;
	public EnemyTank(int x, int y, Dir dir, TankFrame tankFrame) {
		super(x, y, dir, tankFrame);
		this.x = x;
		this.y = y;
		move();
	}

	/*
	 * 实现自由移动
	 */
	private void move() {
		//随机一个初始方向走动，走不动随机换方向
		Dir dir = Dir.getRandomDir();//初始方向
		
		System.out.println(dir);
		switch (dir) {
		case LEFT:
			if(x-speed<7) {
				break;
			}else {
				x -= speed;
				break;
			}
		case RIGHT:
			if (x+speed>TankFrame.GAME_WIDTH-7-50) {
				break;
			} else {
				x += speed;
				break;
			}
		case UP:
			if (y-speed<30) {
				break;
			} else {
				y -= speed;
				break;
			}
		case DOWN:
			if (y+speed>TankFrame.GAME_HEIGHT-30-(50/2)) {
				break;
			} else {
				y += speed;
				break;
			}
		}
		
	}
	@Override
	public void setMoving(boolean moving) {
		// TODO Auto-generated method stub
		super.setMoving(moving);
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		super.fire();
	}

	
}
