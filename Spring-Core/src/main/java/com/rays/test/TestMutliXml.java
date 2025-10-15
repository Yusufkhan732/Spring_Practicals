package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMutliXml {

	public static void main(String[] args) {

		ApplicationContext Context = new ClassPathXmlApplicationContext("Multi.xml");

		Person p = Context.getBean("person", Person.class);

		System.out.println(p.getName());
		System.out.println(p.getAddress());

		System.out.println("---------------------------");

		Employee e = Context.getBean("employee", Employee.class);

		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());
	}
}
