package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("TestUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt service;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("TestUserService");

//		test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testfindByLogin();
		// test.testAuthenticate();
		test.testsearch();

	}

	public void testAdd() throws Exception {

		UserDTO dto = new UserDTO();
		dto.setId(7);
		dto.setFirstName("Shad");
		dto.setLastName("Khan");
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
		System.out.println("Data Deleted :");
	}

	public void testfindByLogin() {

		UserDTO dto = service.findBylogin("admin12");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {

			System.out.println("login not found");
		}
	}

	public void testAuthenticate() {
		UserDTO dto = service.authenticate("admin", "pass1234");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {

			System.out.println("invalid login and password");
		}
	}

	public void testsearch() {

		UserDTO dto = new UserDTO();

		List list = service.search(dto);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			dto = (UserDTO) it.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());

		}
	}
}
