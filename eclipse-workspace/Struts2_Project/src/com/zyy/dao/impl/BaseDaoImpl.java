package com.zyy.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.dao.BaseDao;
import com.zyy.util.SessionUtil;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void delete(Object obj) {
		Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.delete(obj);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}
	}

	@Override
	public Object get(Class cls, Serializable id) {
		Session session = SessionUtil.getSession();
		
		try {
			return session.get(cls, id);
		} catch (Exception e) {
		}finally {
			SessionUtil.closeSession();
		}
		return null;
	}

	@Override
	public List list(String hql) {
		Session session = SessionUtil.getSession();
		
		try {
			return  session.createQuery(hql).list();
		} catch (Exception e) {
		}finally {
			SessionUtil.closeSession();
		}
		return null;
	}

	@Override
	public void save(Object obj) {
		Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(obj);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}
	}

	@Override
	public void update(Object obj) {
		Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.update(obj);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}		
	}

}
