package com.zyy.dao.impl;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;
import com.zyy.dao.UserDao;

public class UserDaoImpl implements UserDao {

	//Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void delete() {
		//logger.log(Level.INFO, "删除之前");
		System.out.println("删除成功");
		//logger.log(Level.INFO, "删除之后");
	}

	@Override
	public void delete2() {
		// TODO Auto-generated method stub
		System.out.println("这是删除2");
	}

}
