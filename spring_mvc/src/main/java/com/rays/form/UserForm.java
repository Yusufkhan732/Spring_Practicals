package com.rays.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {

	protected long id = 0;

	private Long[] ids;

	@NotEmpty(message = "firstName is Required")
	private String firstName;

	@NotEmpty(message = "lastName is Required")
	private String lastName;

	@NotEmpty(message = "login is Required")
	private String login;

	@NotEmpty(message = "password is Required")
	private String password;

	@NotEmpty(message = "address is Required")
	private String address;

	private int pageNo;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
