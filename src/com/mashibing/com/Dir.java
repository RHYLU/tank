package com.mashibing.com;

import java.util.Random;

public enum Dir {
	LEFT,RIGHT,UP,DOWN;
	
	/*
	 * 获取随机方向
	 */
	public static Dir getRandomDir() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
