package com.vnexit.fingerprint.datamodel;

import org.omg.CORBA.PRIVATE_MEMBER;

public class SplitThreshold {

	public SplitThreshold() {
		super();
	}

	public int[] getHistogram(Pixel[][] pi) {
		int[] his = new int[255];
		for (int i = 0; i < 256; i++) {
			int tong = 0;
			for (int y = 0; y < pi.length; y++) {
				for (int j = 0; j < pi[0].length; j++) {
					if (pi[y][j].mBlue == i)
						tong++;
				}
			}
			his[i] = tong;
		}
		return his;
	}
	
	private float[] getDistance(Postition a, Postition b, int[] histogram){
		float[] d=new float[255];
		return d;
	}

	private class Postition {
		private int a;
		private int b;

		public Postition(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		public Postition() {
			super();
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

	}
}
