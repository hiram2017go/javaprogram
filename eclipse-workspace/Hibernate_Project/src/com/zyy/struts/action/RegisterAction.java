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
import com.zyy.struts.form.RegisterForm;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RegisterForm registerForm = (RegisterForm)form;
		SystemMemberDao smDao = new SystemMemberDaoImpl();
		if(smDao.check(registerForm.getName())) {
			request.setAttribute("registerInfo", "当前用户已经存在，请换个名字");
			return mapping.getInputForward();
		}else {
			SystemMember sm = new SystemMember();
			sm.setFullName(registerForm.getFullName());
			sm.setName(registerForm.getName());
			sm.setPassword(registerForm.getPassword());
			
			smDao.register(sm);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", sm);
			return mapping.findForward("main");
		}
	}
}
