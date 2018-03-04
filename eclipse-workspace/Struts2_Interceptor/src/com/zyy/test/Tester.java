package com.zyy.test;

import com.zyy.dao.CustomDao;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.CustomerDaoImpl;
import com.zyy.dao.impl.UserDaoImpl;
import com.zyy.proxy.DynamicProxy;
import com.zyy.proxy.StaticLoggingProxy;

public class Tester {

	public static void main(String[] args) {
		/*// ��̬
		UserDao dao = new UserDaoImpl();
		dao.delete();*/
		
		
		/*//��̬����
		StaticLoggingProxy proxy = new StaticLoggingProxy(new UserDaoImpl());
		proxy.delete();*/
		
		//��̬����
		UserDao dao = (UserDao)new DynamicProxy().bind(new UserDaoImpl());
		dao.delete();//���ú� invoke�󷽷��ᱻ�Զ�����
		
		System.out.println("***************************************************");
		dao.delete2();
		System.out.println("***************************************************");
		CustomDao customerDao = (CustomDao)new DynamicProxy().bind(new CustomerDaoImpl());
		customerDao.update();
	}

}
