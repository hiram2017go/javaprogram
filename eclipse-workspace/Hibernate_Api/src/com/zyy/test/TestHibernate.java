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
			User u = (User)session.get(User.class, id);//load��id������ʱ����null,���ᱨ�쳣��
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
			User u = (User)session.load(User.class, id);//load��id������ʱ�ᱣ�档
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
		//��setsemailֱ��ˢ�µ����ݿ�
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		try {
			User u = (User)session.load(User.class, 5);//load��id������ʱ�ᱣ�档
			u.setName("���Ǹ�ʲô��????????????????????????");
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
	
	//����״̬�ر��ٸ���
	static void update() {
		//��setsemailֱ��ˢ�µ����ݿ�
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		try {
			User u = (User)session.load(User.class, 5);//load��id������ʱ�ᱣ�档
			u.setName("0000999999999999999999999");
			session.close();
			session = util.getSession();
			Transaction tran = session.beginTransaction();//ҲҪ�ٿ���һ�β���
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
