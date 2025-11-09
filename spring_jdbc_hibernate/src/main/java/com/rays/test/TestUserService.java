package com.rays.test;

import java.util.List;

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

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		 test.testAdd();
		// test.testUpdate();
		//test.testDelete();
		 test.testfindBypk();
		// test.testfindBylogin();
		// test.testAuthenticate();
		// test.testsearch();
	}

	public void testAdd() throws Exception {

		UserDTO dto = new UserDTO();
		dto.setFirstName("saseem");
		dto.setLastName("khan");
		dto.setLogin("haseem123@gmail.com");
		dto.setPassword("pass123");
		long pk = service.add(dto);
		System.out.println("Data Inserted :" + pk);

	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(9);
		dto.setFirstName("Shad");
		dto.setLastName("khan");
		dto.setLogin("shad123@gmail.com");
		dto.setPassword("pass123");
		service.update(dto);
	}

	public void testDelete() {
		service.delete(4);
	}

	public void testfindBypk() {

		UserDTO dto = service.findByPk(3);

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Id Not found!");
		}
	}

	public void testfindBylogin() {
		UserDTO dto = service.findBylogin("sanjana123@gmail.com");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Login not found!");
		}
	}

	public void testAuthenticate() {
		UserDTO dto = service.authenticate("shad123@gmail.com", "pass1223");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Login and password  invalid");
		}
	}

	public void testsearch() {

		UserDTO dto = new UserDTO();
		dto.setId(1);
		// dto.setFirstName("Sanjana");
		// dto.setLogin("sanjana123@gmail.com");

		List<UserDTO> list = service.search(dto, 1, 3);

		for (UserDTO udto : list) {
			System.out.print(udto.getId());
			System.out.print("\t" + udto.getFirstName());
			System.out.print("\t" + udto.getLastName());
			System.out.print("\t" + udto.getLogin());
			System.out.println("\t" + udto.getPassword());

		}
	}
}