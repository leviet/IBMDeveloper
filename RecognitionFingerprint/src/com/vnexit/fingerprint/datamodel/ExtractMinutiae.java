package com.vnexit.fingerprint.datamodel;

public class ExtractMinutiae {
	private final Pixel[][] mPi;
	private final double[][] mTeta;
	private final double[][] mFeatured;

	/**
	 * @param mPi
	 * @param mTeta
	 * @param mFeatured
	 */
	public ExtractMinutiae(Pixel[][] mPi, double[][] mTeta, double[][] mFeatured) {
		super();
		this.mPi = mPi;
		this.mTeta = mTeta;
		this.mFeatured = mFeatured;
	}

}
