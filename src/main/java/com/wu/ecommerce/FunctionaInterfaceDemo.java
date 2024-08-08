package com.wu.ecommerce;

public interface FunctionaInterfaceDemo {
	public int add(int a, int b);

	default void test() {
		System.out.println("test");
	}

	default void test1() {
		System.out.println("test1");
	}

	default void test2() {
		System.out.println("test2");
	}
}

class Test {
	public static void getResult(FunctionaInterfaceDemo demo) {
		int result = demo.add(10, 20);
		System.out.println(result);
	}

	public static void main(String[] args) {
		getResult((a, b) -> a + b);
	}
}
