package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	public String login() throws Exception{
		System.out.println("��¼�ɹ�");
		return "loginOK";
	}
	
	public String register() throws Exception{
		System.out.println("ע��ɹ�");
		return "registerOK";
	}
}
