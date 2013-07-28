package com.vnexit.fingerprint.form;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FingerImage extends JPanel {
	
	protected BufferedImage mFinger;
	
	public FingerImage() {
		try {
			mFinger = ImageIO.read(getClass().getResource("1_1.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics g = mFinger.getGraphics();
		g.drawImage(mFinger, 0, 0, null);
	}
	
	public void rePaintLink(String link){
		try {
			mFinger = ImageIO.read(getClass().getResource("vantay1/"+link));
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(mFinger, null, 0, 0);
	}
}
