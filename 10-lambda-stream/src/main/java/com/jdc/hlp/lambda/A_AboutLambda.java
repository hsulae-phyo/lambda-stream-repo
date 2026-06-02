package com.jdc.hlp.lambda;

public class A_AboutLambda {
	public static void main(String[] args) {
		beforeLambda();
	}
	
	static void afterLambda() {
		Order order = (a,b) -> a+b;
		String res = order.checkout(20,"bb");
		System.out.println(res);
	}
	
	static void beforeLambda() {
		Order order = new Order() {
			@Override
			public String checkout(int a, String b) {
				System.out.println("Checkout with lambda.");
				return a+b;
			}
		};
		order.checkout(30, "ss");
	}
}

@FunctionalInterface
interface Order{
	String checkout(int a, String b);
	default void show() {}
}