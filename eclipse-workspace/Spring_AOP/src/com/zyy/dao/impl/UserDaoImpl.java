package com.zyy.dao.impl;

import com.zyy.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public String delete(String arg) {
		
		String str = null;
		//str.length(); //��������throwadvice
		System.out.println("ɾ���ɹ�!"+arg);
		
		return "del ok";
	}

}
