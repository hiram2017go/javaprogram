package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.Answer;
import com.zyy.dao.AnswerDao;
import com.zyy.util.SessionUtil;

public class AnswerDaoImpl extends BaseDaoImpl implements AnswerDao {

	@Override
	public void save(Answer a) {
		Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		String hql = "update Question as q set q.answerCount = q.answerCount + 1 where q.id = ?";
		
		try {
			Query q = session.createQuery(hql);
			q.setInteger(0, a.getQ().getId());
			session.save(a);
			q.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}
	}

	@Override
	public List listAnswerByQuestionID(Integer questionID) {
		// TODO Auto-generated method stub
		String hql = "from Answer as a where a.q.id = ?";
		Session session = SessionUtil.getSession();
		
		Query q = session.createQuery(hql);
		
		try {
			q.setInteger(0, questionID);
			List list = q.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}
		return null;
	}

	@Override
	public List answerDetailLstById(Integer questionID) {
		String hql = "from Answer as a left join fetch a.sm left join fetch a.q where a.q.id=?";
		
		Session session = SessionUtil.getSession();
		
		Query q = session.createQuery(hql);
		
		try {
			q.setInteger(0, questionID);
			List list = q.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}
		return null;
	}

	
}
