package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.Dic;
import com.zyy.dao.DicDao;
import com.zyy.util.HibernateUtil;

public class DicDaoImpl implements DicDao {

	@Override
	public void add(Dic d) {
		// TODO Auto-generated method stub
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(d);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Query q = session.createQuery("from Dic");//from 后的为类名非表名
			
		return q.list();
	}

	@Override
	public List listMajor() {
		// TODO Auto-generated method stub
		return new HibernateUtil().getSession().createQuery("from Major").list();
	}

	@Override
	public List listRegion() {
		// TODO Auto-generated method stub
		return new HibernateUtil().getSession().createQuery("from Region").list();
	}

	@Override
	public List ListPosition() {
		// TODO Auto-generated method stub
		return new HibernateUtil().getSession().createQuery("from Position").list();
	}

}
