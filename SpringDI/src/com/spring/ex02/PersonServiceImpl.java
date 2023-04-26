package com.spring.ex02;

public class PersonServiceImpl implements PersonService{
	//[필드]
	private String name;
	private int age;
	
	//[생성자]
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	public PersonServiceImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//[메서드]
	@Override
	public void sayHello() {
		System.out.println("이름은 " + name + ", 나이는 " + age + "입니다😊");
	}


}
