package com.mashibing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() throws IOException {
		BufferedImage image = ImageIO.read(new File("F:\\work\\eclipse_pro\\tank\\src\\images\\GoodTank1.png"));
		BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
		assertNotNull(image1);
		
	}

}
