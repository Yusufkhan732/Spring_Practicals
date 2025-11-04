package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("TestUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("TestUserService");

		test.testAdd();
		// test.testUpdate();
		// test.testDelete();

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLogin("admin");
		dto.setPassword("pass1234");

		long pk = service.add(dto);
		System.out.println("Data Inserted: " + pk);

	}

	public void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Yusuf");
		dto.setLastName("khan");
		dto.setLogin("Admin");
		dto.setPassword("pass1234");

		service.update(dto);
		System.out.println("Data Updated : ");

	}

	public void testDelete() {

		UserDTO dto = new UserDTO();
		dto.setId(1);
		service.delete(dto);
		System.out.println("Data Delete :");
	}
}
