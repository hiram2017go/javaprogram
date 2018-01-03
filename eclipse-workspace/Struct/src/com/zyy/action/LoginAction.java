package com.zyy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.form.LoginForm;

public class LoginAction extends Action {
//Login.jsp中的form调用的是该方法
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute....");
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");*/
		
		LoginForm loginForm = (LoginForm)form;
		System.out.println("username:"+loginForm.getUsername());
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if(username != null && username.equals("amaker")) {
			//request.getRequestDispatcher("/Success.jsp").forward(request, response);
			return mapping.findForward("success");
		}else {
			//request.getRequestDispatcher("/Failure.jsp").forward(request, response);
			return mapping.findForward("failure");
		}
		//return null;
	}

}
