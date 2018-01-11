package com.zyy.dao;

import java.util.List;

import com.zyy.beans.User;

public interface UserDao {
	public void add(User u);
	
	public User login(String username, String password);
	
	public Boolean check(String username);
	
	public List list();
}
