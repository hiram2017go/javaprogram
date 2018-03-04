package com.zyy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String tip;
	private String name;
	private String password;
	
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String execute() throws Exception {

		if(name != null && name.equals("zyy")) {			
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.put("loginUser", name);
			
			return SUCCESS;
			
		}else {
			this.setTip("帐号名或密码错误，请重新输入!");
			return INPUT;
		}
	}

}
