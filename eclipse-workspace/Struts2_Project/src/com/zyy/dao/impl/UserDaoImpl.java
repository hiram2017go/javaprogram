package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.util.SessionUtil;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User login(String name, String password) {
		String hql = " from User as u where u.name = :name and u.password = :password";
		
		System.out.println("name="+name+";password="+password);
		
		Session session = SessionUtil.getSession();
		Query q = session.createQuery(hql);
		q.setString("name", name);
		q.setString("password", password);
		
		try {
			List list = q.list();
			if (list.size() > 0) {
				System.out.print("-sfsfsdfsdf");
				return (User) list.get(0);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}		
		return null;
	}

	@Override
	public boolean check(String name) {
		
		String hql = "from User as u where u.name = :name";
		Session session = SessionUtil.getSession();
		Query q = session.createQuery(hql);
		q.setString("name", name);
		
		try {
			List list = q.list();
			if (list.size() > 0) {
				return true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			SessionUtil.closeSession();
		}
		return false;
	}

	@Override
	public void register(User u) {
		super.save(u);
	}

}
