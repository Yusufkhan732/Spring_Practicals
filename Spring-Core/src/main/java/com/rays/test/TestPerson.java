package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext Context = new ClassPathXmlApplicationContext(new String[] { "person.xml", "employee.xml" });

		Person p = (Person) Context.getBean("person");

		System.out.println("person's name :" + p.getName());

		System.out.println("person's address:" + p.getAddress());

		System.out.println("--------------------------");

		Employee e = Context.getBean("employee", Employee.class);

		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());

	}
}