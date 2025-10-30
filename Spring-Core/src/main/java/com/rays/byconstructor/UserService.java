package com.rays.byconstructor;

public class UserService {

	private UserDAOInt userDao;

	public UserDAOInt getUserDao() {
		return userDao;
	}

	public UserService(UserDAOInt userdao) {
		this.userDao = userdao;

	}

	public void testAdd() {
		userDao.add();
	}
}
