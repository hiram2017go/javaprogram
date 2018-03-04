package com.zyy.proxy;



import java.util.logging.Level;
import java.util.logging.Logger;

import com.zyy.dao.UserDao;
//静态代理,此处static只是表示静态
//1.代理类和被代理类要实现同一个接口
//2.代理类和被代理类有一种关联关系(需要知道代理的是谁,---厂家代理的是哪家的产品)
public class StaticLoggingProxy implements UserDao {

	UserDao dao;
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public StaticLoggingProxy(UserDao dao){
		this.dao = dao;
	}
	
	public void delete() {
		logger.log(Level.INFO, "调用之前。。。");
		dao.delete(); //传过来是哪个类，此处调用的就是哪个类的方法
		logger.log(Level.INFO, "调用之后。。。");
	}

	@Override
	public void delete2() {
		// TODO Auto-generated method stub
		////////不写了
	}
}
