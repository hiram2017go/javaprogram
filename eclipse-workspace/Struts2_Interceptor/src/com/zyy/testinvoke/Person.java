package com.zyy.testinvoke;

public class Person {

	private String id;
	private String name;
	private String password;
	private int age;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	public int testage(int testage) {
		
		return testage +2;
	}
	
	public String testStr(String namesss) {
		System.out.println("==="+namesss);
		return "..........."+namesss;
	}
}
