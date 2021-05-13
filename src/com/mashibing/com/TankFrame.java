package com.mashibing.com;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame {

	Tank tank = new Tank(400, 400,Dir.UP, Group.GOOD,this);
	List<Tank> enemyList = new ArrayList<>();
	//EnemyTank enemy = new EnemyTank(57, 30, Dir.getRandomDir(), this);
	List<Bullet> bullets = new ArrayList<>();
	//Bullet bullet = new Bullet(500, 500, Dir.UP);
	static int GAME_WIDTH = 1200;
	static int GAME_HEIGHT =800;
	// 构造函数
	public TankFrame() {
		setTitle("TankWar");// 设置标题
		//this.setUndecorated(true);//不显示标题栏不可取
		setSize(GAME_WIDTH, GAME_HEIGHT);// 设置窗口大小
		setResizable(false);// 不可改动窗口大小
		setVisible(true);// 显示窗口

		 //Insets inset = this.getInsets();		//获取标题框大小
		// System.out.println(inset);
		this.addKeyListener(new MyKeyListener());

		addWindowListener(new WindowAdapter() {// 监听Windows，匿名内部类重写
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);// Windows窗口点击×退出
			}
		});
	}

	/*
	 * 防止闪烁
	 */
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {

		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量："+ bullets.size(), 10, 60);
		g.drawString("敌人的数量："+ enemyList.size(), 300, 60);
		g.setColor(c);
		//g.setColor(c);
		
		tank.paint(g);
		for(int i = 0;i < bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		for(int i = 0;i <enemyList.size();i++) {
			enemyList.get(i).paint(g);
		}
		//enemy.paint(g);
		
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < enemyList.size(); j++) {

				bullets.get(i).collideWidth(enemyList.get(j));
			}
		}
	}

	
	class MyKeyListener extends KeyAdapter {

		boolean bL = false; // 设置初始方向
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_SPACE:
				tank.fire();
				break;

			}
			setMainTankDir();
		}

		private void setMainTankDir() {

			if (!bL && !bD && !bU && !bR) {
				tank.setMoving(false);
			} else {
				tank.setMoving(true);
				if (bL) {
					tank.setDir(Dir.LEFT);
				}
				if (bR) {
					tank.setDir(Dir.RIGHT);
				}
				if (bD) {
					tank.setDir(Dir.DOWN);
				}
				if (bU) {
					tank.setDir(Dir.UP);
				}
			}
		}

	}

}
