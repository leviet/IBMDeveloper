package com.vnexit.fingerprint.gaborfilter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.vnexit.fingerprint.datamodel.ImageProcess;
import com.vnexit.fingerprint.datamodel.Pixel;
import com.vnexit.fingerprint.form.FingerImage;

public class GaborFilter extends JPanel{
	BufferedImage mFinger;
	Pixel[][] pi;
	ImageProcess imgProcess;
	WritableRaster wr;

	public GaborFilter() {
		try {
			mFinger = ImageIO.read(getClass().getResource("../datatest/16_1.png"));
			imgProcess =new ImageProcess();
			wr=mFinger.getRaster();
			pi=imgProcess.getData(mFinger);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics g = mFinger.getGraphics();
		g.drawImage(mFinger, 0, 0, null);
	}
	
	public void rePaintLink(String link){
		try {
			mFinger = ImageIO.read(getClass().getResource("../datatest/"+link));
			imgProcess =new ImageProcess();
			wr=mFinger.getRaster();
			pi=imgProcess.getData(mFinger);
			revalidate();
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(mFinger, null, 0, 0);
	}

    
    public void tests() {
    	pi= imgProcess.grayExchange(pi);
    	imgProcess.setData(wr, pi);
    	repaint();
    }
    public void Convolution(){
    	float[] sharpen = {1.0f, -2.0f, 1.0f, -2.0f, 4.0f, -2.0f, 1.0f, -2.0f, 1.0f};
    	Kernel kernel = new Kernel(3, 3, sharpen);
    	BufferedImage img=imgProcess.ConvolutionImage(mFinger, kernel);
    	pi=imgProcess.getData(img);
    	imgProcess.setData(wr, pi);
    	repaint();
    }
    
}
