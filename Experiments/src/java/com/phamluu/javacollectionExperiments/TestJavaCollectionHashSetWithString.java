package com.phamluu.javacollectionExperiments;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;


public class TestJavaCollectionHashSetWithString {
	@Test
	public void test1(){
		
		HashSet<String> tobeTestedSet= new HashSet<>();
		String s1="Aa";
		String s2="BB";
		System.err.println(s1.hashCode());
		System.err.println(s2.hashCode());
		
		tobeTestedSet.add(s1);
		Assert.assertFalse(tobeTestedSet.contains(s2));
		
		
	}

}
