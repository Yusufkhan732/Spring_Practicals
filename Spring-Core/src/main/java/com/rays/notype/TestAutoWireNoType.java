package com.rays.notype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireNoType {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-no-type.xml");

		UserService user = context.getBean("UserService", UserService.class);

		user.testAdd();
	}
}
