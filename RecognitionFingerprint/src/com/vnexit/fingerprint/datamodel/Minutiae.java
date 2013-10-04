package com.vnexit.fingerprint.datamodel;

import java.io.OutputStream;
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
	
	public void writeHeader(PrintStream out){
		out.print("@RELATION FingerPrint\n");
		out.print("@attribute featureMatrix relational\n");
		out.print("@attribute typePoint numeric\n");
		out.print("@attribute gradienPoint numeric\n");
		out.print("@attribute distancePoint numeric\n");
		out.print("@end featureMatrix\n");
		out.print("@attribute class {A, NOT-A}\n\n");
		out.print("@data\n");
	}
	public void writeData(PrintStream out, String clas){
		out.print('"');
		for (int i = 0; i < mNumber; i++) {
			out.print(mType[i]+",");
			out.print(mTeta[i]+",");
			out.print(mDistance[i]);
			if(i!=mNumber-1) out.print("\\n");
		}
		out.print('"');
		out.print(","+clas);
	}

}
