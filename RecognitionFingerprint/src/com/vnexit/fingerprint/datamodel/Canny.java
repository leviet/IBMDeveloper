package com.vnexit.fingerprint.datamodel;

public class Canny {
	private static float[] gau= {2/115f,4/115f,5/115f,4/115f,2/115f,4/115f,9/115f,12/115f,9/115f,4/115f,5/115f,12/115f,15/115f,12/115f,5/115f,4/115f,9/115f,12/115f,9/115f,4/115f,2/115f,4/115f,5/115f,4/115f,2/115f};
	//Ma tran Sobel theo truc x
	private static float[] sobelX = { 1.0f, 0.0f, -1.0f, 2.0f, 0f, -2.0f, 1.0f, 0.0f, -1.0f };
	//Ma tran Sobel theo truc y
	private static float[] sobelY = { 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -2.0f, -1.0f };


}
