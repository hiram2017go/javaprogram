package com.zyy.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.Major;
import com.zyy.bean.Position;
import com.zyy.bean.Region;
import com.zyy.dao.DicDao;
import com.zyy.dao.impl.DicDaoImpl;
import com.zyy.util.HibernateUtil;

public class Tester {
		
	
	public static void main(String[] args) {
	
		/*Major m = new Major();
		m.setName("this is major");
		save(m);
		
		Region r = new Region();
		r.setName("this is Region");
		save(r);
		
		Position p = new Position();
		p.setName("this is Position");
		save(p);*/
		
		get();
	}
	
	
	public static void save(Object o) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(o);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}		
		
	}
	
	public static void get() {
		DicDao dao = new DicDaoImpl();
		List list = dao.listAll();
		System.out.println(list.size());
	}
}
