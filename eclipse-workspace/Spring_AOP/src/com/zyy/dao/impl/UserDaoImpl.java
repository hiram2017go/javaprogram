package com.zyy.dao.impl;

import com.zyy.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public String delete(String arg) {
		
		String str = null;
		//str.length(); //用来测试throwadvice
		System.out.println("删除成功!"+arg);
		
		return "del ok";
	}

}
