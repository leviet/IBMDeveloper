package com.vnexit.fingerprint.datamodel;

import java.io.PrintStream;

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

	public void writeHeader(PrintStream out) {
		out.print("@RELATION FingerPrint\n");
		for (int i = 0; i < mNumber; i++) {
			out.print("@attribute typePoint" + i + " numeric\n");
			out.print("@attribute gradienPoint" + i + " numeric\n");
			out.print("@attribute distancePoint" + i + " numeric\n");
		}
		out.print("@attribute class {A, NOT-A}\n\n");
		out.print("@data\n");
	}

	public void writeData(PrintStream out, String clas) {
		for (int i = 0; i < mNumber; i++) {
			out.print(mType[i] + ",");
			out.print(mTeta[i] + ",");
			out.print(mDistance[i] + ",");
		}
		out.print(clas);
	}

	public void writeData2(PrintStream out, String label) {
		out.print(label + " ");
		int k = 1;
		for (int i = 0; i < mNumber; i++) {
			out.print(k + ":" + mType[i] + " ");
			k++;
			out.print(k + ":" + mTeta[i] + " ");
			k++;
			out.print(k + ":" + mDistance[i] + " ");
			k++;
		}
	}

}
