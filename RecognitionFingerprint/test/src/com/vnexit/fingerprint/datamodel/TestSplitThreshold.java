package com.vnexit.fingerprint.datamodel;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestSplitThreshold {

	@Test
	public void testgethistogram(){
		Pixel[][] pi = new Pixel[2][2];
		pi[0][0] = new Pixel(255, 255, 255);
		pi[0][1] = new Pixel(0, 0, 0);
		pi[1][0] = new Pixel(0, 0, 0);
		pi[1][1] = new Pixel(255, 255, 255);
		
		SplitThreshold split = new SplitThreshold();
		
		int[] his = split.getHistogram(pi);
		
		Assert.assertEquals("So diem co gia tri 0 nen la 2", 2, his[0]);
		Assert.assertEquals("So diem co gia tri 255 nen la 2", 2, his[255]);
		Assert.assertEquals("So diem co gia tri 100 nen la 0", 0, his[100]);
	}
	
	@Test
	public void testgetaveragesample(){
		int[] his = new int[9];
		his[0] = 2;
		his[1] = 4;
		his[2] = 67;
		his[3] = 5;
		his[4] = 123;
		his[5] = 7;
		his[6] = 10;
		his[7] = 15;
		his[8] = 87;
		
		SplitThreshold split = new SplitThreshold();
		
		int res = (int) (split.getAverageSample(his, 0, 1)*3);
		
		Assert.assertEquals("Trung binh mau duoi voi nguong 1 nen la 2/3", 2, res);
		
		res = (int) (split.getAverageSample(his, 6, 8)*112);
		
		Assert.assertEquals("Trung binh mau tren voi nguong 5 nen la 861/112", 861, res);
	}
	
	@Test
	public void testgetIterativeSelection(){
		Pixel[][] pi = new Pixel[2][2];
		pi[0][0] = new Pixel(255, 255, 255);
		pi[0][1] = new Pixel(0, 0, 0);
		pi[1][0] = new Pixel(0, 0, 0);
		pi[1][1] = new Pixel(255, 255, 255);
		
		SplitThreshold split = new SplitThreshold();
		
		Assert.assertEquals("Nguong cua ma tran pixel tren nen la 127", 127, split.getIterativeSelection(pi));
	}
}
