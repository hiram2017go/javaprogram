package com.zyy.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

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
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		//验证error的时候直接直接跳回action配置的input页面。
		ActionErrors errors = new ActionErrors();
		if(username == null ||username.trim().equals("")) { //通过struts的formbean获取到username的值
			errors.add("username", new ActionMessage("login.username"));
			return errors;
		}
		
		if(password == null ||password.trim().equals("")) { //通过struts的formbean获取到password的值
			errors.add("password", new ActionMessage("login.password"));
			return errors;
		}
		
		return null;
	}
	
}
