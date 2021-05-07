package com.mashibing.com;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFrame = new TankFrame();
		while(true) {
			Thread.sleep(100);
			tankFrame.repaint();
		}
	}
}
