package com.vnexit.fingerprint.svm;

import java.util.Random;

import libsvm.svm;
import libsvm.svm_print_interface;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class SVMtester {

	private static svm_print_interface svm_print_null = new svm_print_interface() {
		@Override
		public void print(String s) {
		}
	};

	public static void main(String[] args) throws Exception {

		String fileLocation = "";
		String fileName = "000_L0_1.bmp.arff";

		svm.svm_set_print_string_function(svm_print_null);

		Classifier classifier = null;
		DataSource source = null;
		Instances dataInstances = null;
		Evaluation evaluation = null;

		int sizeOfSearch = 11; // or...

		double[][] resultsArray = new double[sizeOfSearch][sizeOfSearch];

		int kernel = 2;// see weka for parameters

		// this is the power of the cost parameter 2^c
		for (int c = 0; c < sizeOfSearch; c++) {
			// this is the power of the gamma parameter 2^g
			for (int g = 0; g < sizeOfSearch; g++) {

				int cVal = 2 * c - 5; // look at libsvm guide, change if you want
				int gVal = 2 * g - 5;
				double cost = Math.pow(2, cVal);
				double gamma = Math.pow(2, gVal);

				classifier = new LibSVM();

				String[] options = { "-S", "0", "-K", kernel + "", "-D", "3", "-G", gamma + "", "-R", "0.0", "-W", "1.0 2.0", "-N", "0.5", "-M", "40.0", "-C", cost + "", "-E", "0.01", "-P", "0.1" };
				classifier.setOptions(options);

				source = new DataSource(fileLocation + fileName);
				dataInstances = source.getDataSet();
				dataInstances.setClassIndex(dataInstances.numAttributes() - 1);
				classifier.buildClassifier(dataInstances);
				evaluation = new Evaluation(dataInstances);
				evaluation.crossValidateModel(classifier, dataInstances, 10, new Random(1));

				double correct = roundToDecimals(evaluation.pctCorrect(), 2);

				resultsArray[c][g] = correct;
				System.out.println("cost: " + cost + "\tgamma: " + gamma + "\t" + correct);

				classifier = null;
				source = null;
				dataInstances = null;
				evaluation = null;

			}
		}
		System.out.println();
		print(resultsArray);
	}

	public static void print(double[][] in) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				System.out.print(in[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static double roundToDecimals(double d, int c) {
		int temp = (int) ((d * Math.pow(10, c)));
		return ((temp) / Math.pow(10, c));
	}
}