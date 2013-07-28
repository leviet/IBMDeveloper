package com.vnexit.fingerprint.datamodel;

public class Pixel {
	private int mRed;
	private int mGreen;
	private int mBlue;
	
	//Khoi tao khong tham so
	public Pixel(){}
	
	//Khoi tao co tham so
	public Pixel(int r,int g,int b){
		this.mRed=r;
		this.mGreen=g;
		this.mBlue=b;
	}
	
	//Ham set gia tri cho diem anh
	public void setPixel(int r,int g,int b){
		mRed=r;
		mGreen=g;
		mBlue=b;
	}
	
}
