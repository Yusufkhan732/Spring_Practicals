package com.rays.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByName {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-name.xml");

		UserService user = context.getBean("UserService", UserService.class);

		user.testAdd();
	}
}
