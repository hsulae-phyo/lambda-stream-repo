package com.jdc.hlp.streams;

import java.util.List;

public class E_StreamTerminal {
	public static void main(String[] args) {
		//useForEachVsForEachOrdered();
		useChecking();
	}
	
	static void useChecking() {
		List<Integer> list = List.of(2,3,4,5,6,7,8,9,2,1);
		var all = list.stream().allMatch(e -> e < 10);
		var any = list.stream().anyMatch(e -> e == 9);
		var none = list.stream().noneMatch(e -> e != 10);
		System.out.println("AllMatch :: "+ all);
		System.out.println("AnyMatch :: " + any);
		System.out.println("NoneMatch :: "+ none);
	}
	
	static void useForEachVsForEachOrdered() {
		List<Integer> list = List.of(2,3,4,5,6,7,8,9,2,1);
		
		list.stream().forEach(System.out :: println);
		
		//When should use in parallel processing, to get correct ordered and out of all element.
		list.parallelStream()
		.sorted()
		.forEachOrdered(System.out::println);
	}
}
