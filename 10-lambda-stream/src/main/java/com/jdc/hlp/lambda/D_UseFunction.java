package com.jdc.hlp.lambda;

import java.util.function.Function;

public class D_UseFunction {
	
	public static void main(String[] args) {
		useWithoutLambda("22");
	}
	
	static void useLambda(String value) {
		Function<String, Integer> f1 = s -> Integer.parseInt(s);
		System.out.println("Integer gvalue ::: "+f1.apply(value));
	}
	
	void useMethodRefConvert(String value) {
		Function<String, Integer> f1 = this :: convert;
		System.out.println("Integer value ::: "+f1.apply(value));
	}
	
	int convert(String str) {
		return Integer.parseInt(str);
	}
	
	static void useWithoutLambda(String value) {
		Function<String, Integer> f1 = new Function<String, Integer>(){

			@Override
			public Integer apply(String t) {
				return null;
			}	
		};
		System.out.println("Integer value ::: "+f1.apply(value));
	}

}
