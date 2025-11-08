package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto) throws Exception;

	public void update(UserDTO dto);

	public void delete(long id);

	public UserDTO findByPk(long pk);

	public UserDTO findBylogin(String login);

	public UserDTO authenticate(String login, String password);

	public List search(UserDTO dto, int pageNo, int pageSize);
}
