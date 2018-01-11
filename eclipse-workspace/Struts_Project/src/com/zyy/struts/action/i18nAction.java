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

public class i18nAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String l = request.getParameter("l");
		String c = request.getParameter("c");
		
		Locale lc = new Locale(l,c);
		HttpSession session = request.getSession();
		session.setAttribute(Globals.LOCALE_KEY, lc);
		
		return mapping.findForward("login");
	}

}
