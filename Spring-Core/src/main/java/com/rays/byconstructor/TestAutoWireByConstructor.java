package com.rays.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByConstructor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-constructor.xml");

		UserService user = context.getBean("UserService", UserService.class);

		user.testAdd();
	}
}
