package com.mashibing.com;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	private static final int speed = 10;
	Dir dir = Dir.UP;
	int x = 100, y = 100; // 设置初始位置

	// 构造函数
	public TankFrame() {
		setTitle("TankWar");// 设置标题
		setSize(1200, 800);// 设置窗口大小
		setResizable(false);// 不可改动窗口大小
		setVisible(true);// 显示窗口

		this.addKeyListener(new MyKeyListener());

		addWindowListener(new WindowAdapter() {// 监听Windows，匿名内部类重写
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);// Windows窗口点击×退出
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
		// x += 10;
		// y += 100;
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
	}

	class MyKeyListener extends KeyAdapter {

		boolean bL = false; // 设置初始方向
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			System.out.println(key);
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

			default:
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

			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (bL) {
				dir = Dir.LEFT;
			}
			if (bR) {
				dir = Dir.RIGHT;
			}
			if (bD) {
				dir = Dir.DOWN;
			}
			if (bU) {
				dir = Dir.UP;
			}
		}

	}

}
