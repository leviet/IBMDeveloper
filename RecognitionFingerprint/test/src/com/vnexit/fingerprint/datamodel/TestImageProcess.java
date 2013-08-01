package com.vnexit.fingerprint.datamodel;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;

public class TestImageProcess {
	BufferedImage mFinger;
	Pixel[][] pi;
	ImageProcess imgProcess;
	WritableRaster wr;

	@Test
	public void testConvertImagetoGray() throws IOException {
		mFinger = ImageIO.read(getClass().getResource(
				"../datatest/vantay2.png"));
		imgProcess = new ImageProcess(mFinger);
		wr = mFinger.getRaster();
		pi=imgProcess.getData();
		pi = imgProcess.grayExchange(pi);
		Assert.assertEquals(pi.length, mFinger.getHeight());
		for (int i = 0; i < mFinger.getWidth(); i++) {
			for (int j = 0; j < mFinger.getHeight(); j++) {
				Assert.assertEquals(pi[i][j].mBlue, pi[i][j].mGreen);
			}
		}
	}
	@Test
	public void TestConvolutionMatrixImage(){
		int[][] matrix={{1,2,1},{2,1,2},{1,2,1}};
		Pixel pi=new Pixel(1,1,1);
		Pixel pi1=new Pixel(2,2,2);
		Pixel pi2=new Pixel(3,3,3);
		Pixel[][] a={{pi,pi1,pi2}};
		a=imgProcess.ConvolutionImage(a, matrix);
		Assert.assertEquals(a[0][0].mBlue, 8);
		Assert.assertEquals(a[0][1].mBlue, 10);
		Assert.assertEquals(a[0][0].mBlue, a[0][0].mGreen);
	}
}
