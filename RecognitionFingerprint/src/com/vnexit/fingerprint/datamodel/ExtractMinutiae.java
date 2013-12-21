package com.vnexit.fingerprint.datamodel;

public class ExtractMinutiae {
	private static int mNumber = 15;
	private final double[][] mTeta;
	private final int[][] mFeatured;

	/**
	 * @param mPi
	 * @param mTeta
	 * @param mFeatured
	 */
	public ExtractMinutiae(double[][] mTeta, int[][] mFeatured) {
		super();
		this.mTeta = mTeta;
		this.mFeatured = mFeatured;
	}

	public double[] convertArray(double[][] array) {
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

	public int[] convertArray(int[][] array) {
		int[] res = new int[array.length * array[0].length];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				res[k] = array[i][j];
				k++;
			}
		}
		return res;
	}

	public void sortArray(double[] array, int[] tick) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
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

	public double[] findNeighbor(int[][] featured) {
		double[] res = new double[featured.length * featured[0].length];
		int k = 0;
		for (int i = 0; i < featured.length; i++) {
			for (int j = 0; j < featured[0].length; j++) {
				if (featured[i][j] != 0) {
					double min = 9999;
					for (int j2 = 0; j2 < featured.length; j2++) {
						for (int l = 0; l < featured[0].length; l++) {
							if ((j2 != i || l != j) && featured[j2][l] == 2) {
								double tmp = Math.sqrt(Math.pow(i - j2, 2) + Math.pow(j - l, 2));
								if (min > tmp) {
									min = tmp;
								}
							}
						}
					}
					if (min < 9999)
						res[k] = min;
					else
						res[k] = 0;
				} else {
					res[k] = 0;
				}
				k++;
			}
		}
		return res;
	}

	public Minutiae extractMinutiae() {
		double[] distance = findNeighbor(mFeatured);
		int[] tick = new int[distance.length];
		for (int i = 0; i < distance.length; i++) {
			tick[i] = i;
		}

		sortArray(distance, tick);
		double[] te = convertArray(mTeta);
		int[] ty = convertArray(mFeatured);

		double[] mTa = new double[mNumber];
		double[] mDis = new double[mNumber];
		int[] mTy = new int[mNumber];

		for (int i = 0; i < mNumber; i++) {
			mDis[i] = distance[i];
			mTa[i] = te[tick[i]];
			mTy[i] = ty[tick[i]];
		}

		Minutiae minutiae = new Minutiae(mTy, mTa, mDis);

		return minutiae;
	}
}
