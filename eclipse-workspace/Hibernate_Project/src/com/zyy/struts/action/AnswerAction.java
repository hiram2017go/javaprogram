package com.zyy.struts.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zyy.bean.Answer;
import com.zyy.bean.Question;
import com.zyy.bean.QuestionType;
import com.zyy.bean.SystemMember;
import com.zyy.dao.AnswerDao;
import com.zyy.dao.QuestionDao;
import com.zyy.dao.impl.AnswerDaoImpl;
import com.zyy.dao.impl.QuestionDaoImpl;
import com.zyy.struts.form.AnswerForm;
import com.zyy.struts.form.QuestionForm;

public class AnswerAction extends DispatchAction {
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AnswerDao dao = new AnswerDaoImpl();
		
		Integer questionId = Integer.parseInt(request.getParameter("id"));
		System.out.println("id="+questionId);
		request.setAttribute("questionID", questionId);
		QuestionDao qDao = new QuestionDaoImpl();
		Question q = qDao.getQuestionDetailById(questionId);
		
		request.setAttribute("questionDetail", q);
		
		List answerList = dao.answerDetailLstById(questionId);
		request.setAttribute("AnswerList", answerList);
		
		return mapping.getInputForward();
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		AnswerForm answerForm = (AnswerForm)form;
		System.out.println("id==============="+answerForm.getId());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime = sdf.format(new Date());
		
		Answer a = new Answer();
		a.setContent(answerForm.getContent());
		a.setCreateTime(currentTime);
		
		HttpSession session = request.getSession();
		SystemMember sm = (SystemMember)session.getAttribute("loginUser");
		a.setSm(sm);
		
		QuestionDao qDao = new QuestionDaoImpl();
		Question  q = qDao.getQuestionById(answerForm.getId());
		a.setQ(q);
		
		AnswerDao aDao = new AnswerDaoImpl();
		aDao.save(a);
		
		//qDao.updateAnswerCount(answerForm.getId());
		
		return list(mapping,form,request,response);
	}
}
