package com.zyy.dao.impl;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;
import com.zyy.dao.UserDao;

public class UserDaoImpl implements UserDao {

	//Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void delete() {
		//logger.log(Level.INFO, "ɾ��֮ǰ");
		System.out.println("ɾ���ɹ�");
		//logger.log(Level.INFO, "ɾ��֮��");
	}

	@Override
	public void delete2() {
		// TODO Auto-generated method stub
		System.out.println("����ɾ��2");
	}

}
