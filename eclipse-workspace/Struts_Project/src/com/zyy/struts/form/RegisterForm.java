package com.zyy.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class RegisterForm extends ActionForm {
	private String id;
	private String name;
	private String password;
	private String repassword;
	private String fullName;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
//		String password = request.getParameter("password");
//		String repassword = request.getParameter("repassword");
		ActionErrors errors = new ActionErrors();
		
		if(name == null || name.trim().equals("")) {
			errors.add("name", new ActionMessage("registererror.name"));
			return errors;
		}
		
		if(fullName == null || fullName.trim().equals("")) {
			errors.add("fullName", new ActionMessage("registererror.fullName"));
			return errors;
		}
		
		if(password == null || password.trim().equals("")) {
			errors.add("password", new ActionMessage("registererror.password"));
			return errors;
		}
		
		if(!password.equals(repassword)) {
			errors.add("repassword", new ActionMessage("registererror.repassword"));
			return errors;
		}
		
		return null;
	}

}
