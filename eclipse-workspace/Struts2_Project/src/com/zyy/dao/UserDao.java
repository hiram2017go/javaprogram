package com.zyy.dao;

import com.zyy.bean.User;

public interface UserDao {

	public User login(String name, String password);
	
	public boolean check(String name);
	
	public void register(User u);
}
