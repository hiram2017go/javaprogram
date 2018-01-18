package com.zyy.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.categorybean.Book3;
import com.zyy.categorybean.Clothes3;
import com.zyy.extendsbean.Book;
import com.zyy.extendsbean.Clothes;
import com.zyy.maintablbean.Book2;
import com.zyy.maintablbean.Clothes2;
import com.zyy.util.HibernateUtil;


public class Tester {

	public static void main(String[] args) {
		
	/* 第一种调用方式.
	 * 	Book b = new Book();
		b.setName("Thinking in Java");
		b.setPagecount(888);
		save(b);
		
		Clothes c = new Clothes();
		c.setName("Addiss");
		c.setSize(180);
		save(c);*/
		
		/*第二种调用方式.
		Book2 b = new Book2();
		b.setName("Thinking in nodejs");
		b.setPagecount(300);
		save(b);
		
		Clothes2 c = new Clothes2();
		c.setName("MTSBW");
		c.setSize(260);
		save(c);		
		*/
		
		//第3种调用方式
		Book3 b = new Book3();
		b.setName("this is a mogic book!");
		b.setPagecount(1000);
		save(b);
		
		Clothes3 c = new Clothes3();
		c.setName("shirt");
		c.setSize(175);
		save(c);
	}
	
	public static void save(Object cla) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(cla);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
	}
}
