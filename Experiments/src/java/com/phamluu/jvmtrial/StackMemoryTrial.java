package com.phamluu.jvmtrial;

/**
 * This program create  java.lang.StackOverflowError (Stack space).
 * with default configuration, after 8799 call , StackOverflowError will be throw.
 * 
 * with this setting : -Xss128m, set stack memory to 128MB this program reaches more than 1147001 calls
 * 
 * @author UyenPham
 *
 */
public class StackMemoryTrial {
	
	
	public static void main(String[] args){
		System.out.println("Uyen");
		dosomething(1);
	}
	
	private static void dosomething(int i){
		System.out.println("call "+i);
		i++;
		dosomething(i);
	}
	

}
