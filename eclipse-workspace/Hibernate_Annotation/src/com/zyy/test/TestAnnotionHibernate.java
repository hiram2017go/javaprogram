package com.zyy.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.zyy.bean.AnnotionUser;

public class TestAnnotionHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("...");
		System.out.println("标注不需要hbm文件执行hibernate");
		Configuration conf = new Configuration().configure();
		Session session = conf.buildSessionFactory().openSession();
		
		Transaction tran = session.beginTransaction();
		
		try {
			AnnotionUser u = new AnnotionUser();
			u.setName("test55556666666666555");
			u.setPassword("tes55556666666666666t2");
			session.save(u);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
	}

}
