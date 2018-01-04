package com.zyy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//return super.execute(mapping, form, request, response);
		System.out.println("run me!£¡£¡£¡£¡");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null && username.equals("zyy")) {
			return mapping.findForward("success");
		}else{
			return mapping.findForward("failure");
		}
	}

}
