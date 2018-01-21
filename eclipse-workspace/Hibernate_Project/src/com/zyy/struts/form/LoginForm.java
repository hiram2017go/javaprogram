package com.zyy.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm{
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
