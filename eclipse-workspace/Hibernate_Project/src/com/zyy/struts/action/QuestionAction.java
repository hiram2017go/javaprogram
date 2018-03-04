package com.zyy.struts.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zyy.bean.Question;
import com.zyy.bean.QuestionType;
import com.zyy.bean.SystemMember;
import com.zyy.dao.QuestionDao;
import com.zyy.dao.impl.QuestionDaoImpl;
import com.zyy.struts.form.QuestionForm;

public class QuestionAction  extends DispatchAction{

	public ActionForward prepared(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao dao = new QuestionDaoImpl();
		List list = dao.listQuestionType();
		
		request.setAttribute("QuestionTypeList", list);
		return mapping.getInputForward();
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionForm questionForm = (QuestionForm)form;
		System.out.println("qtid="+questionForm.getQuestionTypeID());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime = sdf.format(new Date());
		Question q = new Question();
		q.setContent(questionForm.getContent());
		q.setQuestionKey(questionForm.getQuestionKey());
		q.setCreateTime(currentTime);
		
		HttpSession session = request.getSession();
		SystemMember sm = (SystemMember)session.getAttribute("loginUser");
		q.setSm(sm);
		
		QuestionDao qDao = new QuestionDaoImpl();
		QuestionType  qt = qDao.getQuestion(new Integer(questionForm.getQuestionTypeID()));
		q.setQt(qt);
		
		qDao.save(q);
		
		return mapping.findForward("main");
	}
}
