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
	private UserDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) throws Exception {
		UserDTO user = findBylogin(dto.getLogin());
		if (user != null) {
			throw new Exception("Email already exist!!!....");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {

		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	public UserDTO findBylogin(String login) {
		return dao.findBylogin(login);

	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

	@Override
	public List<UserDTO> list() {

		return dao.list();
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}
}