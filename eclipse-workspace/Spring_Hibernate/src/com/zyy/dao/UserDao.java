package com.zyy.dao;

import java.util.List;

import com.zyy.bean.User;

public interface UserDao {

	public void save(User u);
	public void update(User u);
	public List list();
}