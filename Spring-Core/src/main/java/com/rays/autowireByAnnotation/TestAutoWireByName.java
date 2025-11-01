package com.rays.autowireByAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.test.AppConfig;

public class TestAutoWireByName {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService user = context.getBean(UserService.class);

		user.testAdd();
	}
}
