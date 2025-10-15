package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

		Employee e = context.getBean("employee", Employee.class);

		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());
	}

}
