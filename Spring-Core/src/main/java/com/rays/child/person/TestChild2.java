package com.rays.child.person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestChild2 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("child.xml");

		Person person = (Person) context.getBean("person");

		System.out.println("name: " + person.getName());
		System.out.println("age: " + person.getAge());
	}
}
