package com.vnexit.fingerprint.form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FingerImage extends JPanel {

	public BufferedImage mFinger;

	public FingerImage() {
		try {
			mFinger = ImageIO.read(getClass().getResource("../datatest/testfingerv2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics g = mFinger.getGraphics();
		g.drawImage(mFinger, 0, 0, null);
	}

	public void rePaintLink(String link) {
		try {
			mFinger = ImageIO.read(getClass().getResource("../datatest/" + link));
			revalidate();
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(mFinger, null, 0, 0);
	}
}
