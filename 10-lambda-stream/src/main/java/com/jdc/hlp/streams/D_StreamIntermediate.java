package com.jdc.hlp.streams;

import java.util.stream.IntStream;

public class D_StreamIntermediate {
	 public static void main(String[] args) {
		distinctSkipLimit();
	}
	 
	static void useDistinctSorting() {
		IntStream.of(2,4,2,3,4,2,3,4,6,1,5,7,8,9)
		.distinct()
		.sorted()
		.skip(3)
		.sorted().forEach(System.out :: println);
	}
	
	static void distinctSkipLimit() {
		IntStream.of(2,4,2,3,4,2,3,4,6,1,5,7,8,9)
		.distinct()  //remove duplicate element
		.skip(2)  //skip 2,4
		.limit(5)  //8,9
		.forEach(System.out :: println);
		
	}
}
