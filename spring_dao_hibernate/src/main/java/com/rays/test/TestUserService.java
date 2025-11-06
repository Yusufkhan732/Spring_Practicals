package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testAdd();

		// test.testUpdate();
		
		test.testDelete();
	}

	public void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("Amit");
		dto.setLastName("kirar");
		dto.setLogin("amit123@gmail.com");
		dto.setPassword("pass123");
		long pk = service.add(dto);
		System.out.println("Data Inserted :" + pk);

	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Shad");
		dto.setLastName("khan");
		dto.setLogin("shad123@gmail.com");
		dto.setPassword("pass123");
		service.update(dto);
	}

	public void testDelete() {
		service.delete(4);
	}
}
