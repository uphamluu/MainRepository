package com.phamluu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComGen {
	public static void main (String[] args){
		System.out.println("Uyen");
		
		Map<Integer, List<String>> results = new HashMap<>();
		List<List<String>> setOfSetOfElement = new ArrayList<>();
		
		List<String> list1 =  Stream.of("1","2","3", "4").collect(Collectors.toList());
		setOfSetOfElement.add(list1);
		
		List<String> list2 = Stream.of("a","b","c", "d").collect(Collectors.toList());;
		setOfSetOfElement.add(list2);
		
		List<String> list3 = Stream.of("M","N","O", "P").collect(Collectors.toList());;
		setOfSetOfElement.add(list3);
		
		List<String> list4 = Stream.of("§","$","%", "&").collect(Collectors.toList());;
		setOfSetOfElement.add(list4);
		
		int level = 1;
		for(List<String> aaa:  setOfSetOfElement){
			List<String> ccc = results.getOrDefault(level-1, new ArrayList<>());
			if (ccc.isEmpty()){
				results.put(level, aaa);
			} else {
				List<String> dd= new ArrayList<>();
				for (String c : ccc) {
					for (String bb : aaa) {
						dd.add(c+bb);

					}
				}
				results.put(level, dd);
			}
			level++;
		}
		
//		results.entrySet().forEach(i->i.getValue().stream().forEach(j->System.out.println(j) )  );
		Stream ggg= results.entrySet().stream().filter(i->i.getKey() == setOfSetOfElement.size());
				
				
		ggg.forEach(j->System.out.println(j) ) ;
		
	}

}
