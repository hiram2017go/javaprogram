package com.zyy.test;

import com.zyy.bean.SystemMember;
import com.zyy.dao.BaseDao;
import com.zyy.dao.impl.BaseDaoImpl;

public class Tester {
	
	public static void main(String[] args) {
		BaseDao bd = new BaseDaoImpl();
		SystemMember sm = new SystemMember();
		sm.setFullName("shabi");
		sm.setName("gun");
		sm.setPassword("123456");
		bd.save(sm);
		
	}
}
