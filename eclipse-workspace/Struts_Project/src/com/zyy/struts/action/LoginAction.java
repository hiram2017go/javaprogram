package com.zyy.struts.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.beans.User;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.UserDaoImpl;
import com.zyy.struts.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)form;
		UserDao userDao = new UserDaoImpl();
		User u = userDao.login(loginForm.getUsername(), loginForm.getPassword());
		if(u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", u);
			return mapping.findForward("success");
		}else {		
			request.setAttribute("loginInfo", "用户名或密码错误!");
			return mapping.getInputForward();
		}
	}
}
