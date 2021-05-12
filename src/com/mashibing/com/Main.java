package com.mashibing.com;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFrame = new TankFrame();
		for (int i = 0; i < 5; i++) {
			tankFrame.enemyList.add(new Tank(50+i*100, 400, Dir.DOWN, tankFrame));
		}
		while(true) {
			Thread.sleep(100);
			tankFrame.repaint();
		}
	}
}
