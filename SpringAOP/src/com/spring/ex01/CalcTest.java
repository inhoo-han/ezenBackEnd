package com.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		//빈을 생성한 것을 application에서 읽어들임
		ApplicationContext context = new ClassPathXmlApplicationContext("aoptest.xml");
		Calculator calc = (Calculator)context.getBean("proxyCal");
		calc.add(20, 30);
		System.out.println("===========================");
		calc.subtract(50, 17);
		System.out.println("===========================");
		calc.multiply(5, 88848448);
		System.out.println("===========================");
		calc.divide(50, 10);
		System.out.println("===========================");
		calc.mod(34, 9);
		System.out.println("===========================");
		
	}

}
