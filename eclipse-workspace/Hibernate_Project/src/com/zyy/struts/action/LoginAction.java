package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.bean.SystemMember;
import com.zyy.dao.SystemMemberDao;
import com.zyy.dao.impl.SystemMemberDaoImpl;
import com.zyy.struts.form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("login in......");
		
		LoginForm loginForm = (LoginForm)form;
		System.out.println("username="+loginForm.getUsername());
		
		SystemMemberDao smDao = new SystemMemberDaoImpl();
		SystemMember sm = smDao.login(loginForm.getUsername(), loginForm.getPassword());
		HttpSession session =  request.getSession();
		session.setAttribute("loginUser", sm);
		if(sm != null) {
			return mapping.findForward("main");
		}else {
			request.setAttribute("loginInfo", "用户名或密码错误，请重新登录！");
			return mapping.getInputForward();
		}
	}

}
