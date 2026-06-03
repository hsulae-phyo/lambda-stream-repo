package com.jdc.hlp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class B_StreamCreation {
	public static void main(String[] args) {
		//useCollectionOrArray();
		//useRange();
		//useIterate();
		//useGenerate();
		//useFactory();
		useBuilder();
	}
	
	//if so many parameters in constructor               
	static void useBuilder() {
		Stream.builder()
		.add("a")
		.add("b")
		.build().forEach(System.out::println);
	}
	
	static void useFactory() {
		var stream = Stream.of(1,2,3).mapToInt(i -> i).sum();
		System.out.println("Random value :: "+stream);
		
		var inStream = IntStream.of(2,3,4).sum();
		System.out.println("IntStream :: "+inStream);
	}
	
	static void useGenerate() {
		Random rand = new Random();  //Effectively Final, cause of use in lambda
		int res = IntStream.generate(() -> rand.nextInt(6)).findFirst().getAsInt();
		System.out.println("Random vlaue :: "+ res);
	}
	
	static void useIterate() {
		
		Stream.iterate("a", x -> x).limit(5).forEach(System.out::println);
		//Stream.iterate("a", x -> x).limit(5).forEach(a -> System.out.println(a));
		
		var i = DoubleStream.iterate(1 , x -> x +1).limit(5).sum();
		System.out.println("Stream 1 to 5 :: "+i);
		
//		out value => 1(init value), 2 (1*2), 3 (2*2)
		var l = LongStream.iterate(1, x -> x*2).limit(3).sum();
		System.out.println("Lomg Stream 1 to 3 ::"+l);
	}
	
	static void useRange() {
		var i = IntStream.range(1, 10).sum();
		System.out.println("IntStream :: "+i);
	
		var l = LongStream.rangeClosed(1, 10).sum();
		System.out.println("LongStram :: "+l);
	}
	
	static void useCollectionOrArray() {
		List<String> list = List.of("1","2","3","4","5","6","7","8","9");
		String[] array = {"1","2","3","4","5","6","7","8","9"};
		
		var listRes = list.stream().mapToInt(s -> Integer.parseInt(s)).sum();
		System.out.println("List result :: "+listRes);
		
		var arrayRes = Arrays.stream(array)
				.mapToInt(Integer :: parseInt)
				.sum();
		
		System.out.println("Array result :: "+arrayRes);
	}
}
