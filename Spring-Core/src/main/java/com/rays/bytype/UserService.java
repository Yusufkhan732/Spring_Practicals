package com.rays.bytype;

public class UserService {

	private UserDAOInt userDao;

	public UserDAOInt getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}
