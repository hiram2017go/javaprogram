package com.zyy.springtest;

public class HelloWorld {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String Hello() {
		return "Hello " + name;
	}

}
