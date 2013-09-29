package com.vnexit.fingerprint.datamodel;

public class ExtractFeatured {
	public ExtractFeatured() {

	}

	public int[][] getFeatured(Pixel[][] pi) {
		int[][] res = new int[pi.length][pi[0].length];
		for (int i = 1; i < pi.length - 1; i++) {
			for (int j = 1; j < pi[0].length - 1; j++) {
				res[i][j] = getFeatured(pi, i, j);
			}
		}
		return res;
	}

	public int getFeatured(Pixel[][] pi, int i, int j) {
		if (pi[i][j].mBlue == 255)
			return 0;
		int numberPoint = 0;
		for (int m = i - 1; m <= i + 1; m++) {
			for (int n = j - 1; n <= j + 1; n++) {
				if (pi[m][n].mBlue == 0)
					numberPoint++;
			}
		}
		if (numberPoint == 2)
			return 1;
		if (numberPoint > 3)
			return 2;
		return 0;
	}
}
