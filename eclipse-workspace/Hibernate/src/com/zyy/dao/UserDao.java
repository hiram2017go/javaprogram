package com.zyy.dao;

import java.util.List;

import com.zyy.bean.User;

public interface UserDao {
	public void save(User u);
	
	public User get(int id);
	
	public void delete(int id);
	
	public List list();
}
