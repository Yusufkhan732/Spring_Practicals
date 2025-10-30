package com.rays.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByType {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-type.xml");

		UserService user = context.getBean("UserService", UserService.class);

		user.testAdd();
	}
}
