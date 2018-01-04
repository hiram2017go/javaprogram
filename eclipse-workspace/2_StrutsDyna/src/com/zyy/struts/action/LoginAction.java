package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm loginForm = (DynaActionForm)form;
		String username = loginForm.getString("username");
		String password = loginForm.getString("password");
		System.out.println("username="+username+";password="+password);
		
		request.setAttribute("username", username);
		if(username != null && username.equals("zyy")) {
			return mapping.findForward("success");
		}else {
			return mapping.findForward("failure");
		}
	}

}
