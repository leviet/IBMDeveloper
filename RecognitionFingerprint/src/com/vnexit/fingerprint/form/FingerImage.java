package com.vnexit.fingerprint.form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FingerImage extends JPanel {
	private BufferedImage mFinger;

	public FingerImage(String link) {
		try {
			mFinger = ImageIO.read(getClass().getResource(link));
		} catch (IOException e) {
		}
		Graphics g = mFinger.getGraphics();
		g.drawImage(mFinger, 0, 0, null);
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(mFinger, null, 0, 0);
	}
}
