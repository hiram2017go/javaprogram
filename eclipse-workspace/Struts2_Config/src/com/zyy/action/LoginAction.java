package com.zyy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String username;
	private String password;
	
	private String tip;

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		if(username != null && username.equals("zyy")) {
			
			return "success";
		}else {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();   /*使用map的put加入session，不与serverlet耦合.*/
			session.put("sessionname", "hahahahha");
			
			this.setTip("wrong name or password!");
			return "input";
		}
	}
}
