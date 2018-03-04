package com.zyy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.Question;
import com.zyy.bean.QuestionType;
import com.zyy.dao.QuestionDao;
import com.zyy.util.SessionUtil;

public class QuestionDaoImpl extends BaseDaoImpl implements QuestionDao {

	@Override
	public List listQuestion() {
		String hql = "from Question";
		return super.list(hql);
	}

	@Override
	public List listQuestionType() {
		String hql = "from QuestionType";
		return super.list(hql);
	}

	@Override
	public void save(Question q) {

		super.save(q);
	}

	@Override
	public QuestionType getQuestion(Integer id) {
		return (QuestionType)super.get(QuestionType.class, id);
	}

	@Override
	public List questionDetailList() {
		String hql = "from Question as q left join fetch q.sm left join fetch q.qt";
		
		return super.list(hql);
	}

	@Override
	public Question getQuestionDetailById(Integer id) {
		String hql = "from Question as q left join fetch q.sm where q.id = ?";
		Session session = SessionUtil.getSession();
		
		Query q = session.createQuery(hql);
		
		try {
			q.setInteger(0, id);
			List list = q.list();
			if(list == null || list.size() == 0) return null;
			
			return (Question)list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SessionUtil.closeSession();
		}
		return null;
	}

	@Override
	public Question getQuestionById(Integer id) {
		return (Question)super.get(Question.class, id);
	}

	@Override
	public void updateAnswerCount(Integer id) {

		Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			String hql = "update Question as q set q.answerCount = q.answerCount + 1 where q.id = ?";
			Query q = session.createQuery(hql);
			q.setInteger(0, id);
			q.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}
	}

}
