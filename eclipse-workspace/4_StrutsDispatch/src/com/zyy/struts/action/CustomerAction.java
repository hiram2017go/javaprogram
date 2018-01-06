package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class CustomerAction extends DispatchAction {

	/*@Override
	public ActionForward execute(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// TODO Auto-generated method stub
		return super.execute(arg0, arg1, arg2, arg3);
	}*/
	
	public ActionForward save(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("save................");
		return null;
	}
	
	public ActionForward update(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("update................");
		return null;
	}
	
	public ActionForward delete(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("delete................");
		return null;
	}

}
