package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public long add(UserDTO dto) throws Exception {
		String sql = "insert into st_user values(?,?,?,?,?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	@Override
	public void update(UserDTO dto) {
		String sql = "update st_user set first_name = ?,last_name =?,login = ?,password = ? where id = ?";

		int pk = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

	}

	@Override
	public void delete(UserDTO dto) {
		String sql = "delete from st_user where id = ?";

		int pk = jdbcTemplate.update(sql, dto.getId());

	}

	@Override
	public UserDTO findBylogin(String login) {
		UserDTO user = null;
		try {

			String sql = "select * from st_user where login = ?";
			Object[] param = { login };
			user = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return user;
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		UserDTO user = null;
		try {

			String sql = "select * from st_user where login = ? and password = ?";
			Object[] param = { login, password };

			user = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;

	}

	@Override
	public List<UserDTO> list() {

		return search(null);
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (dto != null) {

			if (dto.getId() > 0) {
				sql.append("AND id ='" + dto.getId());
			}

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append("AND firstName like'" + dto.getFirstName() + "%'");
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append("AND lastName like'" + dto.getLastName() + "%'");
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append("AND login like'" + dto.getLogin() + "%'");
			}
		}
		List list = jdbcTemplate.query(sql.toString(), new UserMapper());

		return list;
	}
}
