package com.zyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyy.dao.UserDao;

public class Tester {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext("beans.xml");  
		UserDao dao = (UserDao)context.getBean("factory");
		dao.delete("amaker");
	}

}
