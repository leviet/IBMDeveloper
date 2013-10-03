package com.vnexit.fingerprint.datamodel;

public class ExtractMinutiae {
	private static int mNumber = 20;
	private final double[][] mTeta;
	private final double[][] mFeatured;

	/**
	 * @param mPi
	 * @param mTeta
	 * @param mFeatured
	 */
	public ExtractMinutiae(double[][] mTeta, double[][] mFeatured) {
		super();
		this.mTeta = mTeta;
		this.mFeatured = mFeatured;
	}

	private double[] convertArray(double[][] array) {
		double[] res = new double[array.length * array[0].length];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				res[k] = array[i][j];
				k++;
			}
		}
		return res;
	}

	private void sortArray(double[] array, int[] tick) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					double tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					int ti = tick[i];
					tick[i] = tick[j];
					tick[j] = ti;
				}
			}
		}
	}
}
