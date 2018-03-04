package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private String username;
	private String password;
	private int age;
	private String birthday;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	private String url;
	private String email;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
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
	public String execute() throws Exception {

		System.out.println("执行了。。。。");
		
		return SUCCESS;
	}
	
	/*//服务器端手动验证
	@Override
	public void validate() {
		
		System.out.println("验证了。。。。。。");
		
		if(username != null && username.trim().equals("")) {
			this.addFieldError("username", "用户名不能为空");
		}
		
		if(password != null && password.trim().equals("")) {
			this.addFieldError("password", "用户密码不能为空");
		}
		
	}	*/
	
}
