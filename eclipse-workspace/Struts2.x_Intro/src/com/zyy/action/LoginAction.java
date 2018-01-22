package com.zyy.action;

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
	
	public String execute() throws Exception{
		if(username != null && username.equals("zyy")) {
			return "index";
		}else {
			this.setTip("用户名或密码错误");
			return "input";
		}
	}
}
