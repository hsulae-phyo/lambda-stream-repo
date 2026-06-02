package com.jdc.hlp.lambda;

public class C_MethodReference {
	public static void main(String[] args) {
		useLambda();
		System.out.println();
		useMethodReference();
	}
	
	static void useMethodReference() {
		FunctionalOne one = FunctionalReference :: useStatic;
		one.withoutReturn("one reference");
		
		FunctionalReference ref = new FunctionalReference();
		FunctionalTwo two = ref :: useInstance;
		System.out.println(two.withReturn("two ref"));
		
		FunctionalThree three = FunctionalReference :: new;
		three.withoutReturn();
	}
	
	static void useLambda() {
		FunctionalOne functionalOne = message -> System.out.println(message);
		functionalOne.withoutReturn("One");
		
		FunctionalTwo functionalTwo = message -> message;
		String res = functionalTwo.withReturn("Two");
		System.out.println(res);
		
		FunctionalThree functionalThree = () -> System.out.println("Three");
		functionalThree.withoutReturn();
	
	}
}

@FunctionalInterface
interface FunctionalOne{
	void withoutReturn(String message);
}

@FunctionalInterface
interface FunctionalTwo{
	String withReturn(String message);
}

@FunctionalInterface
interface FunctionalThree{
	void withoutReturn();
}


class FunctionalReference{
	public FunctionalReference() {
		System.out.println("Using Constructor!");
	}
	
	static void useStatic(String mess) {
		System.out.println("Using static method reference with :: "+ mess);
	}
	
	String useInstance(String mess) {
		return "Using instance method with :: "+mess;
	}
}
