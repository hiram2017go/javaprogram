package com.zyy.test;


import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.UserDaoImpl;

public class TestHibernate {

	
	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		User u = new User();
		u.setName("shuaige");
		u.setPassword("1111111");
		
		UserDao dao = new UserDaoImpl();
		dao.save(u);
		System.out.println("-========================================");
	}

}
