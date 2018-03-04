package com.zyy.erraction;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterErrorAction extends ActionSupport {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("name="+name+";age="+age);
		return null;
	}
	
}
