package com.mashibing.com;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame  extends Frame{
		
	//构造函数
		public TankFrame(){
			setTitle("TankWar");//设置标题
			setSize(1200,800);//设置窗口大小
			setResizable(false);//不可改动窗口大小
			setVisible(true);//显示窗口
			
			addWindowListener(new WindowAdapter() {//监听Windows，匿名内部类重写
				@Override
				public void windowClosing(WindowEvent e) {
					//super.windowClosing(e);
					System.exit(0);//Windows窗口点击×退出
				}
			});
		}
		
		@Override
		public void paint(Graphics g) {
			g.fillRect(200, 200, 50, 50);
		}
	
}
