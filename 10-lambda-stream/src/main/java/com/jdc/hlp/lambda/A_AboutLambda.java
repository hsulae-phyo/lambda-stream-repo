package com.jdc.hlp.lambda;

public class A_AboutLambda {
	public static void main(String[] args) {
		beforeLambda();
	}
	
	static void afterLambda() {
		Order order = () -> System.out.println("Checkout with lambda.");
		order.checkout();
	}
	
	static void beforeLambda() {
		Order order = new Order() {
			@Override
			public void checkout() {
				System.out.println("Checkout with lambda.");
			}
		};
		order.checkout();
	}
}

interface Order{
	void checkout();
}