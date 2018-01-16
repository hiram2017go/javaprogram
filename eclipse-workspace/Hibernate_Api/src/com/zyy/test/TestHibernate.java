package com.zyy.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.User;
import com.zyy.util.HibernateUtil;

public class TestHibernate {

	static void get(Integer id) {
		
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		try {
			User u = (User)session.get(User.class, id);//load在id不存在时返回null,不会报异常。
			System.out.println(u.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	
	static void load(Integer id) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		try {
			User u = (User)session.load(User.class, id);//load在id不存在时会保存。
			System.out.println(u.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	
	static void saveorupdate(User u) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		try {
			session.saveOrUpdate(u);
			
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
	}
	
	static void flush() {
		//对setsemail直接刷新到数据库
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		try {
			User u = (User)session.load(User.class, 5);//load在id不存在时会保存。
			u.setName("这是个什么呢????????????????????????");
			session.flush();
			System.out.println(u.getName());
			
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
		
	}
	
	//游离状态关闭再更新
	static void update() {
		//对setsemail直接刷新到数据库
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		try {
			User u = (User)session.load(User.class, 5);//load在id不存在时会保存。
			u.setName("0000999999999999999999999");
			session.close();
			session = util.getSession();
			Transaction tran = session.beginTransaction();//也要再开启一次才行
			System.out.println(u.getName());
			session.update(u);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			//tran.rollback();
		}finally {
			session.close();
		}
		
	}
	
	
	public static void main(String[] args) {
		/*load(new Integer(3));
		get(new Integer(5));
		flush();
		get(new Integer(5));*/
		/*User u = new User();
		u.setId(19);
		u.setName("888888888888888888888888888");
		saveorupdate(u);*/
		
		update();
		
		
	}

}
