package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		//PersonTest실행 시 person.xml을 읽어들이는 작업(=빈을 생성하는 작업)을 진행하여 생성된 객체 정보를 factory변수에 부여
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		//생성된 객체 이름을 가져온다.
		//인터페이스 = (인터페이스로 형변환)생성된 클래스 객체               ->       다형성!
		PersonService person = (PersonService)factory.getBean("personService");
		
		//Spring을 사용하지 않았더라면
//		PersonServiceImpl personService = new PersonServiceImpl();
//		personService.setName("강백호");
//		personService.setAge(17);
//		PersonService person = (PersonService)personService;
		person.sayHello();
	}

}
