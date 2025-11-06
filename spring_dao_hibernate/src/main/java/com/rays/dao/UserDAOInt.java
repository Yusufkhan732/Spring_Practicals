package com.rays.dao;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(long id);

	public UserDTO findBypk(long id);

	public UserDTO findBylogin(String login);

}
