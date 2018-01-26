package com.phamluu.nn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Trainer {
	public static int INPUT_COUNT=1;
	public static int OUTPUT_COUNT=1;

	public static void main(String[] args) {
		System.out.println("Uyen");
		
		Network nn1= new Network(INPUT_COUNT, 1);
		float[] aa= {0.5f};
		System.out.println("Before trainning:");
		System.out.println( nn1.feedForward(aa));
		
//		nn1.displayNetwork();
		
		int count=10000000;
		float[][] trainningSet =  prepareTrainningSet(count);
		for (int i=0; i< trainningSet.length; i++ ){
			float[] input = Arrays.copyOfRange(trainningSet[i], 0, INPUT_COUNT);
			float[] tobeTrainneResult = Arrays.copyOfRange(trainningSet[i], INPUT_COUNT, trainningSet[i].length);
			nn1.train(input, tobeTrainneResult[0]);
		}
		System.out.println("");
		System.out.println("After trainning:");
		System.out.println("input: "+aa[0]+ " output:"+ nn1.feedForward(aa));
		System.out.println("input: 0.75 output:"+ nn1.feedForward(new float[]{0.75f}));
		System.out.println("input: 0.16 output:"+ nn1.feedForward(new float[]{0.16f}));
		System.out.println("input: 0.01 output:"+ nn1.feedForward(new float[]{0.01f}));
		
		NNSaver saver= new NNSaver();
		System.out.println("NN:");
		nn1.displayNetwork();
		saver.saveNetworkToFile(nn1, "trained_nn_2018_01_23");
		System.out.println("*************************************");
		System.out.println("loading NN");
		Network nn2 = saver.loadNetworkFromFile("trained_nn_2018_01_23");
		nn2.displayNetwork();
		
		System.out.println("*************************************");
		

	}
	
	private static float[][] prepareTrainningSet(int count){
		float[][] result= new float[count][INPUT_COUNT+OUTPUT_COUNT];
		for (int i=0; i< count; i++){
			float[] aTrainingSet= new float[INPUT_COUNT+OUTPUT_COUNT];
			
			float input  = (float) Math.random()*2-1;
			aTrainingSet[0]= input;
			aTrainingSet[1]= input/2;
			result[i] = aTrainingSet;
		}
		
		
		return result;
	}

}
