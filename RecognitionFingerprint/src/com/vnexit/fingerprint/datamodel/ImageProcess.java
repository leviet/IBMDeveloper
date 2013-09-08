package com.vnexit.fingerprint.datamodel;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class ImageProcess {
	private BufferedImage mBimg;
	private Pixel[][] mPi;

	public ImageProcess() {
	}

	public Pixel[][] getData(BufferedImage mBimg) {
		Raster r = mBimg.getRaster();
		Pixel[][] data = new Pixel[r.getWidth()][r.getHeight()];
		int[] v = new int[3];
		v[0] = v[1] = v[2] = 0;

		for (int i = 0; i < r.getWidth(); i++) {
			for (int j = 0; j < r.getHeight(); j++) {
				v = r.getPixel(i, j, v);
				Pixel newPixel = new Pixel(v[0], v[1], v[2]);
				data[i][j] = newPixel;
			}
		}
		return data;
	}

	public void setData(WritableRaster wr, Pixel[][] data) {
		int[] p = new int[3];
		for (int i = 0; i < wr.getWidth(); i++) {
			for (int j = 0; j < wr.getHeight(); j++) {
				p[0] = data[i][j].mRed;
				p[1] = data[i][j].mGreen;
				p[2] = data[i][j].mBlue;
				wr.setPixel(i, j, p);
			}
		}
	}

	public Pixel[][] grayExchange(Pixel[][] pi) {
		int s = 0;
		for (int i = 0; i < pi.length; i++) {
			for (int j = 0; j < pi[0].length; j++) {
				s = Math.max(pi[i][j].mRed, Math.max(pi[i][j].mGreen, pi[i][j].mBlue));
				Pixel p = new Pixel(s, s, s);
				pi[i][j] = p;
			}
		}
		return pi;
	}

	public BufferedImage ConvolutionImage(BufferedImage mBimg, Kernel matrix) {
		BufferedImage img = null;
		try {
			BufferedImageOp b = new ConvolveOp(matrix);
			img = b.filter(mBimg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}

	public double getMi(Pixel[][] pi) {
		double vaule = 0;
		double size = pi.length * pi[0].length;
		for (int i = 0; i < pi.length; i++) {
			for (int j = 0; j < pi[0].length; j++) {
				vaule += pi[i][j].mBlue;
			}
		}
		return (vaule / size);
	}

	public double getVi(Pixel[][] pi) {
		double mi = getMi(pi);
		double vaule = 0;
		double size = pi.length * pi[0].length;
		for (int i = 0; i < pi.length; i++) {
			for (int j = 0; j < pi[0].length; j++) {
				vaule += Math.pow(pi[i][j].mBlue - mi, 2);
			}
		}
		return (vaule / size);
	}

	public Pixel[][] IncreaseFinger(Pixel[][] pi) {
		double Mi0 = 150.0, Vi0 = 5400.0;
		double mi = getMi(pi);
		double vi = getVi(pi);
		System.out.print(vi + "-" + mi);
		for (int i = 0; i < pi.length; i++) {
			for (int j = 0; j < pi[0].length; j++) {
				double s = 0;
				if (pi[i][j].mBlue >= mi) {
					s = Mi0 + Math.sqrt(Vi0 * Math.pow(pi[i][j].mBlue - mi, 2) / vi);
				} else {
					s = Mi0 - Math.sqrt(Vi0 * Math.pow(pi[i][j].mBlue - mi, 2) / vi);
				}
				int x = (int) s;
				Pixel px = new Pixel(x, x, x);
				pi[i][j] = px;
			}
		}
		return pi;
	}

}
