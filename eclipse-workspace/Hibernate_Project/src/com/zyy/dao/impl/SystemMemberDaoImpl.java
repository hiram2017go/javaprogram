package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zyy.bean.SystemMember;
import com.zyy.dao.SystemMemberDao;
import com.zyy.util.SessionUtil;

public class SystemMemberDaoImpl extends BaseDaoImpl implements SystemMemberDao {

	@Override
	public SystemMember login(String username, String password) {
		String hql = "from SystemMember as sm where sm.name = :name and sm.password = :password";
		
		Session session = SessionUtil.getSession();
		Query q = session.createQuery(hql);
		q.setString("name", username);
		q.setString("password", password);
		
		try {
			List list = q.list();
			if (list.size() > 0) {
				return (SystemMember) list.get(0);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}
		
		return null;
	}

	@Override
	public boolean check(String username) {
		String hql = "from SystemMember as sm where sm.name = :name";
		
		Session session = SessionUtil.getSession();
		Query q = session.createQuery(hql);
		q.setString("name", username);
		
		try {
			List list = q.list();
			if (list.size() > 0) {
				return true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}
		return false;
	}

	@Override
	public void register(SystemMember sm) {
		super.save(sm);
	}

}
