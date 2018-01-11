package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zyy.beans.User;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.UserDaoImpl;
import com.zyy.struts.form.RegisterForm;

public class RegisterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RegisterForm registerForm = (RegisterForm)form;
		UserDao dao = new UserDaoImpl();
		if(dao.check(registerForm.getName())){
			request.setAttribute("registerInfo", "��ǰ��¼���Ѿ�����!");
			return mapping.getInputForward();
		}else {
			User u = new User();
			u.setFullName(registerForm.getFullName());
			u.setName(registerForm.getName());
			u.setPassword(registerForm.getPassword());
			dao.add(u);
			request.setAttribute("loginInfo", "ע��ɹ������¼�ʺ�ʹ�ã�");
			return mapping.findForward("login");
		}		
	}
}
