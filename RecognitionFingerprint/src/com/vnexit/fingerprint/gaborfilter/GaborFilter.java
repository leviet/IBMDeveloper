package com.vnexit.fingerprint.gaborfilter;

import java.awt.Dimension;
import java.awt.image.WritableRaster;

import javax.swing.JPanel;

import com.vnexit.fingerprint.datamodel.ImageProcess;
import com.vnexit.fingerprint.datamodel.Pixel;
import com.vnexit.fingerprint.form.FingerImage;

public class GaborFilter extends FingerImage{
	
	Pixel[][] pi;
	ImageProcess imgProcess=new ImageProcess(this.mFinger);
	WritableRaster wr;

	public GaborFilter(){
		pi= imgProcess.getData();
		wr = this.mFinger.getRaster();
	}
	
    public Pixel[][] grayExchange() {
    	pi= imgProcess.getData();
        int s = 0;
        for (int i = 0; i < this.mFinger.getWidth(); i++) {
            for (int j = 0; j < this.mFinger.getHeight(); j++) {
                s = Math.max(pi[i][j].mRed, Math.max(pi[i][j].mGreen, pi[i][j].mBlue));
                Pixel p = new Pixel(s, s, s);
                pi[i][j] = p;
            }
        }
        return pi;
    }
    
    public void chuanhoa() {
        pi = grayExchange();
        imgProcess.setData(wr, pi);
        repaint();
    }
    
}
