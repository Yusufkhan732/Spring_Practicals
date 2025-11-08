package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	public long add(UserDTO dto) {

		return dao.add(dto);
	}

	public void update(UserDTO dto) {
		dao.update(dto);

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
