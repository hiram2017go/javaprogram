package com.zyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao dao = (UserDao)ac.getBean("userDao");
		User u = new User();
		u.setAge(200);
		u.setUsername("monkey");
		//dao.save(u);
		dao.delete(1);
	}

}
