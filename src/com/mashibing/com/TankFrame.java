package com.mashibing.com;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	Tank tank = new Tank(100, 100, Dir.UP);

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

		tank.paint(g);

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
