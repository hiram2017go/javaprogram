package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		System.out.println("厉害了，说明已经登录了");
		
		return SUCCESS;
	}

}
