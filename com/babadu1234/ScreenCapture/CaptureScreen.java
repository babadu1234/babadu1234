package com.babadu1234.ScreenCapture;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CaptureScreen {

	public static void screenCapture() {
		try {
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage screenCapturer = new Robot()
					.createScreenCapture(screenSize);
			ImageIO.write(screenCapturer, "png", new File("Untitled.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
