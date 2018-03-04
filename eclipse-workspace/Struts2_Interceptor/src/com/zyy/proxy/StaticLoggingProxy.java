package com.zyy.proxy;



import java.util.logging.Level;
import java.util.logging.Logger;

import com.zyy.dao.UserDao;
//��̬����,�˴�staticֻ�Ǳ�ʾ��̬
//1.������ͱ�������Ҫʵ��ͬһ���ӿ�
//2.������ͱ���������һ�ֹ�����ϵ(��Ҫ֪���������˭,---���Ҵ�������ļҵĲ�Ʒ)
public class StaticLoggingProxy implements UserDao {

	UserDao dao;
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public StaticLoggingProxy(UserDao dao){
		this.dao = dao;
	}
	
	public void delete() {
		logger.log(Level.INFO, "����֮ǰ������");
		dao.delete(); //���������ĸ��࣬�˴����õľ����ĸ���ķ���
		logger.log(Level.INFO, "����֮�󡣡���");
	}

	@Override
	public void delete2() {
		// TODO Auto-generated method stub
		////////��д��
	}
}
