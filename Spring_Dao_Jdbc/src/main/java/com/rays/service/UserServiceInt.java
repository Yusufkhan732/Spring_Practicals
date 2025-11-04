package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto) throws Exception;

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findBylogin(String login);

	public UserDTO authenticate(String login, String password);

	public List<UserDTO> list();

	public List<UserDTO> search(UserDTO dto);

}
