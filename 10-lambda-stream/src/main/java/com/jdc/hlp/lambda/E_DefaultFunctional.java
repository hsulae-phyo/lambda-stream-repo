package com.jdc.hlp.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class E_DefaultFunctional {
	public static void main(String[] args) {
		useConsumer(23,30);
		usePredicate();
	}
	
	static void useFunction() {
		Function<String, Integer> f = x-> Integer.parseInt(x);
		System.out.println(f.apply("34"));
		
		Function<String, Integer> r = Integer :: parseInt;
		System.out.println(r.apply("34"));
		
		BiFunction<Integer, Integer, String> b = (x,y) -> "Result :"+(x+y);
		System.out.println(b.apply(20, 30));
	}
	
	static void useOperator() {
		UnaryOperator<String> o = a -> "use : "+a;
		System.out.println(o.apply("unary"));
		
		BinaryOperator<String> b = (x,y) -> "use : "+x+y;
		System.out.println(b.apply("binary", "test"));
	}
	
	static void useSupplier() {
		Supplier<String> s = () -> "Hsu";
		System.out.println(s.get());
	}
	
	static void usePredicate() {
		Predicate<Integer> p = t -> t == 5;
		boolean result = p.test(5);
		System.out.println(result);
		
		BiPredicate<Integer, Integer> bp = (a,b) -> a%b == 0;
		System.out.println(bp.test(10, 2));
	}
	
	static void useConsumer(int a, int b) {
		Consumer<Integer> c1 = x -> System.out.println("Use consumer ::: "+x);
		Consumer<Integer> c2 = y -> c1.accept(y+11);
		c1.andThen(c2);
		c2.accept(a);
		
		
		BiConsumer<Integer, Integer> c3 = (x,y) -> System.out.println("Use Biconsumer :::"+(x+y));
		c3.accept(a, b);
	}
}
