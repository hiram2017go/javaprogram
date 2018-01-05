package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.struts.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)form;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		System.out.println("username:"+username);
		if(username == null || username.length() < 5) {
			request.setAttribute("msg", "非法用户名"+username);
			return mapping.findForward("login");
		}		
		return mapping.findForward("welcome");
	}

}
