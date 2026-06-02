package com.jdc.hlp.lambda;

public class B_LambdaUsage {
	public static void main(String[] args) {
		withoutLambda();
	}
	
	static void Lambda() {
		Producer p = () -> 30;
		Consumer c = a -> System.out.println(a);
		c.set("test");
	}
	
	
	static void withoutLambda() {
		Producer p = new Producer() {
			@Override
			public int Produce() {
				return 30;
			}
		};
		System.out.println(p.Produce());
		Consumer c = new Consumer() {
			@Override
			public void set(String a) {
				System.out.println("Consumer ::: "+a);
			}
		};
		c.set("test");
	}
}

@FunctionalInterface
interface Producer{
	int Produce();
}

@FunctionalInterface
interface Consumer{
	void set(String a);
}
