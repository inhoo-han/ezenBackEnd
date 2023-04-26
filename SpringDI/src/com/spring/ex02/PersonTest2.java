package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest2 {

	public static void main(String[] args) {
		//PersonTest실행 시 person.xml을 읽어들이는 작업(=빈을 생성하는 작업)을 진행하여 생성된 객체 정보를 factory변수에 부여
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));

		PersonService person1 = (PersonService)factory.getBean("personService1");
		person1.sayHello();
		PersonService person2 = (PersonService)factory.getBean("personService2");
		person2.sayHello();
	}
}
