package com.rays.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message = "Email is Required")
	@Email(message = "Invalid email format")
	private String login;

	@NotEmpty(message = "Password is Required")
	private String password;

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

}
