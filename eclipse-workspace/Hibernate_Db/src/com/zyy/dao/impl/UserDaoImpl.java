package com.zyy.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(u);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}
	}

}
