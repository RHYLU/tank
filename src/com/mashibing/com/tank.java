package com.mashibing.com;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tank {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("TankWar");//设置标题
		f.setSize(1200,800);//设置窗口大小
		f.setResizable(false);//不可改动窗口大小
		f.setVisible(true);//显示窗口
		
		f.addWindowListener(new WindowAdapter() {//监听Windows，匿名内部类重写
			@Override
			public void windowClosing(WindowEvent e) {
				//super.windowClosing(e);
				System.exit(0);//Windows窗口点击×退出
			}
		});
	}
}
