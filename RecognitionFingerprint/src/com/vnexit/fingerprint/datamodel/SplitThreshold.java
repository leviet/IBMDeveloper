package com.vnexit.fingerprint.datamodel;

public class SplitThreshold {

	public SplitThreshold() {
		super();
	}

	public int[] getHistogram(Pixel[][] pi) {
		int[] his = new int[256];
		System.out.print("Histogram: ");
		for (int i = 0; i < 256; i++) {
			int tong = 0;
			for (int y = 0; y < pi.length; y++) {
				for (int j = 0; j < pi[0].length; j++) {
					if (pi[y][j].mBlue == i)
						tong++;
				}
			}
			his[i] = tong;
			System.out.print(tong + " ");
		}
		return his;
	}

	private int getDistance(Postition a, Postition b, int[] histogram) {
		float d = 0;
		float max = 0;
		int k = 0;
		float B = -11 * (a.getA() - b.getA());
		float A = 1 * (a.getB() - b.getB());
		float C = -a.getA() * (a.getB() - b.getB()) + a.getB() * (a.getA() - b.getA());
		for (int i = a.getA(); i < b.getA(); i++) {
			d = (float) Math.abs((A * i + B * histogram[i] + C) / Math.sqrt(A * A + B * B));
			if (max < d) {
				max = d;
				k = i;
			}
		}
		return k;
	}

	public int getThreshold(Pixel[][] pi) {
		int[] his = getHistogram(pi);
		Postition min = getMinPostition(his);
		Postition max = getMaxPosition(his);
		return getDistance(min, max, his);
	}

	public Pixel[][] splitThreshold(Pixel[][] pi, int thres) {
		Pixel tmp = new Pixel();
		for (int i = 0; i < pi.length; i++) {
			for (int j = 0; j < pi[0].length; j++) {
				if (pi[i][j].mBlue > thres) {
					tmp = new Pixel(255, 255, 255);
					pi[i][j] = tmp;
				} else {
					tmp = new Pixel(0, 0, 0);
					pi[i][j] = tmp;
				}
			}
		}
		return pi;
	}

	private Postition getMaxPosition(int[] histogram) {
		int max = 2;
		for (int i = 3; i < 256; i++) {
			if (histogram[i] > histogram[max]) {
				max = i;
			}
		}

		return new Postition(max, histogram[max]);
	}

	private Postition getMinPostition(int[] histogram) {
		int min = 255;
		for (int i = 1; i < 256; i++) {
			if ((min > i) && (histogram[min] >= histogram[i]))
				min = i;
		}
		return new Postition(min, histogram[min]);
	}

	/*
	 * @return Ma tran sau khi tach nguong Tinh trung binh gia tri diem anh trong 16 o lan can Neu gia tri diem anh lon hon gia tri tb -> 255 else ->0
	 */
	public Pixel[][] newSplitThreshold(Pixel[][] pi) {
		int i = 0, j = 0, m = 0, n = 0;
		for (i = 8; i < pi.length - 8; i++) {
			System.out.print("\n");
			for (j = 8; j < pi[0].length - 8; j++) {
				int sum = 0;
				for (m = i - 8; m < i + 8; m++) {
					for (n = j - 8; n < j + 8; n++) {
						sum += pi[m][n].mBlue;
					}
				}
				if (pi[i][j].mBlue > (sum / 256)) {
					Pixel tmp = new Pixel(255, 255, 255);
					pi[i][j] = tmp;
				} else {
					Pixel tmp = new Pixel(0, 0, 0);
					pi[i][j] = tmp;
				}
				System.out.print(sum / 64 + " ");
			}
		}
		return pi;
	}

	public double getAverageSample(int[] his, int min, int max) {
		int tu = 0;
		int mau = 0;
		for (int i = min; i <= max; i++) {
			tu += his[i] * i;
			mau += his[i];
		}
		return (double) tu / mau;
	}

	public int getThresholdNext(int[] his, int old) {
		double sampleBottom = getAverageSample(his, 0, old);
		double sampleTop = getAverageSample(his, old + 1, 255);
		return (int) ((sampleBottom + sampleTop) / 2);
	}

	public int getIterativeSelection(Pixel[][] pi) {
		int[] his = getHistogram(pi);
		int threshold = 100;
		int nextThreshold = getThresholdNext(his, threshold);
		while (threshold != nextThreshold) {
			threshold = nextThreshold;
			nextThreshold = getThresholdNext(his, threshold);
		}
		return threshold;
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
