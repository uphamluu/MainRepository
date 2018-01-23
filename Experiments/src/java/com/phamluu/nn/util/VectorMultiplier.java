package com.phamluu.nn.util;

public class VectorMultiplier {
	int VECTOR_SIZE = 3;
	
	public static void main (String[] args){
		float[] v1= {0.15f, 0.2f, 0.35f};
		float[] v2 = { 0.05f, 0.1f, 1f };
		multiplyAndDisplay(v1, v2);
		System.out.println("---------------------------------");
		
		v1 = generateRandomVector(20);
		v2 = generateRandomVector(20);
		multiplyAndDisplay(v1, v2);
		
//		v1 = generateRandomVector(200);
//		v2 = generateRandomVector(200);
//		multiplyAndDisplay(v1, v2);
		
		System.out.println("start");
		long start = System.currentTimeMillis(); 
		for (int i=0; i<1000000; i++){
			v1 = generateRandomVector(500);
			v2 = generateRandomVector(500);
			multiply(v1, v2);
		}
		long end = System.currentTimeMillis();
		System.out.println("done: "+ (end-start)+("ms"));
		
		
	}
	
	private static void multiplyAndDisplay(float[] v1, float[] v2) {
		System.out.print("v1: ");
		displayVector(v1);
		System.out.println();
		System.out.print("v2: ");
		displayVector(v2);
		System.out.println();
		System.out.print("result: ");
		System.out.println(multiply(v1, v2));
		
	}
	
	
	

	private static Float multiply(float[] v1, float[] v2) {
		if (v1.length !=v2.length){
			return null;
		}
		int vectorSize= v1.length;
		float sum=0.0f;
		for (int i=0; i<vectorSize; i++){
			sum += v1[i]*v2[i];
			
		}
		return sum;
		
	}
	
	
	private static float[] generateRandomVector(int size){
		float[] result = new float[size];
		for (int i=0; i<size; i++){
			result[i]= (float) Math.random()*2-1;
		}
		
		
		return result;
		
	}
	private static void displayVector(float[] vect){
		for (int i=0; i<vect.length; i++){
			System.out.print(vect[i]+"  ");
		}
			
		
		
	}
	
	

}
