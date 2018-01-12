package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		Session session = new HibernateUtil().getSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(u);
			tran.commit();	
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();	
		}
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		Session session = new HibernateUtil().getSession();		
		try {
			Query q = session.createQuery("from usertbl");
			List list = q.getResultList();
			return list;
		}catch(Exception ex) {
			System.out.println("获取list列表失败!");	
		}finally {
			session.close();
		}		
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = new HibernateUtil().getSession();
		Transaction tran = session.beginTransaction();
		try {
			User u = (User)session.get(User.class, new Integer(id));
			session.delete(u);
			tran.commit();
		}catch(Exception ex) {
			tran.rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		Session session = new HibernateUtil().getSession();
		User u = (User)session.get(User.class, new Integer(id));
		
		return u;
	}
}
