package com.vnexit.fingerprint.datamodel;

public class Minutiae {
	private static int mNumber = 20;
	private int[] mType = new int[mNumber];
	private double[] mTeta = new double[mNumber];
	private double[] mDistance = new double[mNumber];

	/**
	 * @param mType
	 * @param mTeta
	 * @param mDistance
	 */
	public Minutiae(int[] mType, double[] mTeta, double[] mDistance) {
		super();
		this.mType = mType;
		this.mTeta = mTeta;
		this.mDistance = mDistance;
	}

	public static int getmNumber() {
		return mNumber;
	}

	public int[] getmType() {
		return mType;
	}

	public double[] getmTeta() {
		return mTeta;
	}

	public double[] getmDistance() {
		return mDistance;
	}

}
