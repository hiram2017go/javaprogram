package com.zyy.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.bean.Question;
import com.zyy.bean.QuestionType;
import com.zyy.dao.QuestionDao;
import com.zyy.dao.impl.QuestionDaoImpl;

public class QuestionListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao dao = new QuestionDaoImpl();
		
		//因为要获取到SystemMember QuestionType，所以要加载到暑假，需要将SystemMember.hbm.xml QuestionType.hbm.xml 设置lazy=false
//		List list = dao.listQuestion();
//		for(int i = 0; i< list.size();i++) {
//			Question q = (Question)list.get(i);
//			System.out.println(q.getSm().getName());//没有lazy=false会报错
//		}
		
		//而下面使用fetch查询到不需要使用lazy=false
		List list = dao.questionDetailList();
//		for(int i = 0; i< list.size();i++) {
//			Question q = (Question)list.get(i);
//			System.out.println("-----"+q.getSm().getName());
//
//			System.out.println("==="+q.getQt().getName());
//		}
		
		request.setAttribute("QuestionList", list);
		
		return mapping.getInputForward();
	}
}
