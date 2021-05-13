package com.mashibing.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {

	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private int step = 0;
	private int x, y;
	TankFrame tFrame = null;
	
	public Explode(int x, int y,  TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tFrame = tf;
	}

	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step>=ResourceMgr.explodes.length) step = 0;
	}
	
}
