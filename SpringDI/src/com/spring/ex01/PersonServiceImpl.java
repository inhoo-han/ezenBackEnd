package com.spring.ex01;

public class PersonServiceImpl implements PersonService{
	
	private String name;
	private int age;
	
	//setter만 준비
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void sayHello() {
		System.out.println("이름은 " + name + ", 나이는 " + age + "입니다😊");
	}
	
}
