package com.mashibing.com;

public class Judge {

	private int x,y;
	
	public boolean judje(int width,int height) {
		if(width<0||height<0||width>TankFrame.GAME_WIDTH||height>TankFrame.GAME_HEIGHT) {
			return false;
		}
		return true;
	}
}
