package com.spring.ex01;
//target class

public class Calculator {
	
	//[method]
	public void add(int a, int b) {
		int result = a + b;
		System.out.println("✔두 수의 합은 " + result + "입니다.");
	}
	
	public void subtract(int a, int b) {
		int result = a - b;
		System.out.println("✔두 수의 차는 " + result + "입니다.");
	}
	
	public void multiply(int a, int b) {
		int result = a * b;
		System.out.println("✔두 수의 곱은 " + result + "입니다.");
	}
	
	public void divide(int a, int b) {
		int result = a / b;
		System.out.println("✔" + a + "나누기" + b + "의 몫은 " + result + "입니다.");
	}
	
	public void mod(int a, int b) {
		int result = a % b;
		System.out.println("✔" + a + "나누기" + b + "의 나머지는 " + result + "입니다.");
	}
}

