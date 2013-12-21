package com.vnexit.fingerprint.datamodel;

import org.junit.Assert;
import org.junit.Test;

public class TestThinningProcess {

	@Test
	public void testConvertMatrixPixelToBinary() {
		Pixel[][] pi = new Pixel[2][2];
		pi[0][0] = new Pixel(255, 255, 255);
		pi[0][1] = new Pixel(0, 0, 0);
		pi[1][0] = new Pixel(0, 0, 0);
		pi[1][1] = new Pixel(255, 255, 255);

		ThinningProcess thinning = new ThinningProcess();
		int[][] res = thinning.convertMatrix(pi);

		Assert.assertEquals("Gia tri tai vi tri [0][0] sau khi convert nen la 0", 0, res[0][0]);
		Assert.assertEquals("Gia tri tai vi tri [0][1] sau khi convert nen la 1", 1, res[0][1]);
		Assert.assertEquals("Gia tri tai vi tri [1][0] sau khi convert nen la 1", 1, res[1][0]);
		Assert.assertEquals("Gia tri tai vi tri [1][1] sau khi convert nen la 0", 0, res[1][1]);
	}

	@Test
	public void testCheckDeletePosition() {
		Pixel[][] pi = new Pixel[2][2];
		pi[0][0] = new Pixel(255, 255, 255);
		pi[0][1] = new Pixel(0, 0, 0);
		pi[1][0] = new Pixel(0, 0, 0);
		pi[1][1] = new Pixel(255, 255, 255);

		ThinningProcess thinning = new ThinningProcess();

		int[][] res = thinning.convertMatrix(pi);

	}

	@Test
	public void TestgetNoneZezo() {
		int[][] pi = new int[3][3];
		pi[0][0] = 0;
		pi[0][1] = 0;
		pi[0][2] = 1;
		pi[1][0] = 1;
		pi[1][1] = 1;
		pi[1][2] = 0;
		pi[2][0] = 0;
		pi[2][1] = 1;
		pi[2][2] = 1;

		ThinningProcess thinning = new ThinningProcess();

		Assert.assertEquals("So diem khac khong trong ma tran tam tai 1,1 nen la 4", 4, thinning.getNoneZezo(pi, 1, 1));
	}

	@Test
	public void TestgetNumber0transitions1() {
		int[][] pi = new int[3][3];
		pi[0][0] = 0;
		pi[0][1] = 1;
		pi[0][2] = 1;
		pi[1][0] = 1;
		pi[1][1] = 1;
		pi[1][2] = 0;
		pi[2][0] = 0;
		pi[2][1] = 1;
		pi[2][2] = 1;

		ThinningProcess thinning = new ThinningProcess();

		Assert.assertEquals("So cap 0-1 trong ma tran tam tai 1,1 nen la 3", 3, thinning.getNumber0transitions1(pi, 1, 1));
	}

	@Test
	public void TestcheckSymmetric() {
		int[][] pi = new int[3][3];
		pi[0][0] = 0;
		pi[0][1] = 1;
		pi[0][2] = 1;
		pi[1][0] = 1;
		pi[1][1] = 1;
		pi[1][2] = 0;
		pi[2][0] = 0;
		pi[2][1] = 1;
		pi[2][2] = 1;

		ThinningProcess thinning = new ThinningProcess();

		Assert.assertEquals(true, thinning.checkSymmetric(pi, 1, 1));

		pi[0][1] = 0;

		Assert.assertEquals(false, thinning.checkSymmetric(pi, 1, 1));
	}

}
