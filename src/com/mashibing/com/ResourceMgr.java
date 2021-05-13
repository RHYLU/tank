package com.mashibing.com;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {

	public  static BufferedImage tankL ,tankU,tankD,tankR;
	public  static BufferedImage bulletL ,bulletU,bulletD,bulletR;
	public static BufferedImage [] explodes = new BufferedImage[16];
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTankL.png"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTankR.png"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTankU.png"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTankD.png"));
			
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.png"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.png"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.png"));
			for (int i = 0; i < explodes.length; i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
