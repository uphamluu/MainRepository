package com.phamluu.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTraining {
	
	public static void main(String[] args){
		Stream<Integer> stream = Stream.of(1,2,3,4,5, 6, 7);
		Map<Integer,Integer> intMap = stream.collect(Collectors.toMap(i -> i, i -> i+10));
		intMap.entrySet().forEach(i->System.out.println(i.getKey()+"_"+i.getValue()));
		
		
	}

}
