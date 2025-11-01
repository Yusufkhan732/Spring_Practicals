package com.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.test.AppConfig;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = (Person) context.getBean(Person.class);

		System.out.println("Person' name: " + person.getName());
		System.out.println("Person'address: " + person.getAddress());
	}
}
