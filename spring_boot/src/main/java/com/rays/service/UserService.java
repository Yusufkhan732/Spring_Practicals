package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAO userDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {

		long pk = userDAO.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		userDAO.update(dto);

	}

}
