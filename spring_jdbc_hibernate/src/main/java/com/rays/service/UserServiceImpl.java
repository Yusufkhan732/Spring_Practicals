package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOHiberImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dao.UserDAOJDBCImpl;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	// Hibernate se
	@Autowired
	private UserDAOHiberImpl HibernateDao;
	// Jdbc se
	@Autowired
	private UserDAOJDBCImpl jdbcDao;

	public long add(UserDTO dto) throws Exception {

		return HibernateDao.add(dto);
	}

	public void update(UserDTO dto) {
		jdbcDao.update(dto);

	}

	public void delete(long id) {
		HibernateDao.delete(id);

	}

	public UserDTO findByPk(long pk) {
		return HibernateDao.findByPk(pk);
	}

	public UserDTO findBylogin(String login) {
		return HibernateDao.findBylogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return HibernateDao.authenticate(login, password);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		return HibernateDao.search(dto, pageNo, pageSize);
	}
}
