package com.vnexit.fingerprint.datamodel;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestExtractMinutiae {

	@Test
	public void testfindNeighbor() {
		int[][] fea = new int[5][5];
		for (int i = 0; i < fea.length; i++) {
			for (int j = 0; j < fea[0].length; j++) {
				fea[i][j] = 0;
			}
		}
		fea[1][1] = 1;
		fea[1][4] = 1;
		fea[2][2] = 1;
		fea[3][0] = 2;
		fea[3][3] = 2;
		double[][] teta = new double[5][5];
		ExtractMinutiae ex = new ExtractMinutiae(teta, fea);
		
		double[] res = ex.findNeighbor(fea);
		
		Assert.assertEquals("Hang xom loai 2 gan nhat cua (1,1) la Math.sqrt(5)", 5, (int)Math.pow(res[6],2));
		Assert.assertEquals("Hang xom loai 2 gan nhat cua (3,0) la Math.sqrt(9)", 9, (int)Math.pow(res[15],2));
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+"\t");
		}
		System.out.print("\n"+Math.sqrt(5));
	}
	@Test
	public void TestsortArray(){
		int[][] fea = new int[5][5];
		for (int i = 0; i < fea.length; i++) {
			for (int j = 0; j < fea[0].length; j++) {
				fea[i][j] = 0;
			}
		}
		fea[1][1] = 1;
		fea[1][4] = 1;
		fea[2][2] = 1;
		fea[3][0] = 2;
		fea[3][3] = 2;
		double[][] teta = new double[5][5];
		ExtractMinutiae ex = new ExtractMinutiae(teta, fea);
		double[] res = ex.findNeighbor(fea);
		int[] tick = new int[res.length];
		for (int i = 0; i < res.length; i++) {
			tick[i]=i;
		}
		
		ex.sortArray(res, tick);
		
		Assert.assertEquals("Vi tri nho nhat la 12", 12, tick[0]);
		Assert.assertEquals("Vi tri nho t2 la 9", 9, tick[1]);
		Assert.assertEquals("Vi tri nho t3 la 6", 6, tick[2]);
		Assert.assertEquals("Vi tri nho t4 la 15", 15, tick[3]);
		Assert.assertEquals("Vi tri nho t5 la 18", 18, tick[4]);
	}
	@Test
	public void testextractMinutiae() {
		int[][] fea = new int[5][5];
		double[][] teta = new double[5][5];
		for (int i = 0; i < fea.length; i++) {
			for (int j = 0; j < fea[0].length; j++) {
				fea[i][j] = 0;
				teta[i][j] = 5;
			}
		}
		fea[1][1] = 1;
		fea[1][4] = 1;
		fea[2][2] = 1;
		teta[2][2] = 3;
		fea[3][0] = 2;
		fea[3][3] = 2;
		
		ExtractMinutiae ex = new ExtractMinutiae(teta, fea);
		
		Minutiae mi = ex.extractMinutiae();

		int[] mTy = mi.getmType();
		double[] mTa = mi.getmTeta();
		double[] mDis = mi.getmDistance();
		
		Assert.assertEquals("Loai diem co w nho nhat la 1", 1, mTy[0]);
		Assert.assertEquals("Huong co w nho nhat la 3", 3, (int)mTa[0]);
		System.out.print("\n");
		for (int i = 0; i < mDis.length; i++) {
			System.out.print(mTy[i] + "\t" + mTa[i] + "\t" + mDis[i]+"\n");
		}
		System.out.print("\\n");
	}

}
