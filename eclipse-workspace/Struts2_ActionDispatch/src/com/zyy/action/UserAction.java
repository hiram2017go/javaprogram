package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	public String login() throws Exception{
		System.out.println("登录成功");
		return "loginOK";
	}
	
	public String register() throws Exception{
		System.out.println("注册成功");
		return "registerOK";
	}
}
