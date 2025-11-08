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

	@Autowired
	private UserDAOHiberImpl dao;
	
	@Autowired
	private UserDAOJDBCImpl jdbcDAO ;
	

	public long add(UserDTO dto) throws Exception {

		return jdbcDAO.add(dto);
	}

	public void update(UserDTO dto) {
		jdbcDAO.update(dto);

	}

	public void delete(long id) {
		dao.delete(id);

	}

	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}

	public UserDTO findBylogin(String login) {
		return dao.findBylogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}
