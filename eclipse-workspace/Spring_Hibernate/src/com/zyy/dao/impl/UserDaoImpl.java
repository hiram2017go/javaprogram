package com.zyy.dao.impl;

import java.util.List;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;

public class UserDaoImpl extends HibernateTemplate implements UserDao {

	SessionFactory sessionFactory;
	
	
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return super.find(hql);
	}

}
