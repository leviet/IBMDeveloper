package com.vnexit.fingerprint.datamodel;

import junit.framework.Assert;

import org.junit.Test;

public class TestExtractFeatured {

	@Test
	public void testgetfeature() {
		Pixel[][] pi = new Pixel[3][3];
		pi[0][0] = new Pixel(255, 255, 255);
		pi[0][1] = new Pixel(255, 255, 255);
		pi[0][2] = new Pixel(255, 255, 255);
		pi[1][0] = new Pixel(255, 255, 255);
		pi[1][1] = new Pixel(255, 255, 255);
		pi[1][2] = new Pixel(255, 255, 255);
		pi[2][0] = new Pixel(255, 255, 255);
		pi[2][1] = new Pixel(255, 255, 255);
		pi[2][2] = new Pixel(255, 255, 255);

		ExtractFeatured ex = new ExtractFeatured();

		Assert.assertEquals("Diem 1-1 trong ma tra tran ko phai diem dac trung", 0, ex.getFeatured(pi, 1, 1));
		pi[1][1] = new Pixel(0, 0, 0);
		pi[1][0] = new Pixel(0, 0, 0);
		Assert.assertEquals("Diem 1-1 trong ma tra tran la diem ke thuc", 1, ex.getFeatured(pi, 1, 1));
		pi[0][1] = new Pixel(0, 0, 0);
		pi[2][2] = new Pixel(0, 0, 0);
		Assert.assertEquals("Diem 1-1 trong ma tra tran la diem re nhanh", 2, ex.getFeatured(pi, 1, 1));

	}
}
