package com.zyy.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		System.out.println("�����ˣ�˵���Ѿ���¼��");
		
		return SUCCESS;
	}

}
