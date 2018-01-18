package com.zyy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zyy.bean.Major;
import com.zyy.bean.Position;
import com.zyy.bean.Region;
import com.zyy.dao.DicDao;
import com.zyy.dao.impl.DicDaoImpl;
import com.zyy.struts.form.DicForm;

public class DicAction extends DispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		DicForm df = (DicForm)form;
		System.out.println("-------------"+df.getCategory());
		String category = df.getCategory();
		
		if(category == null) return null;
		DicDao dao = new DicDaoImpl();
		if(category.equals("M")) {
			Major m = new Major();
			m.setName(df.getName());
			dao.add(m);
		}else if(category.equals("R")) {
			Region m = new Region();
			m.setName(df.getName());
			dao.add(m);
		}else if(category.equals("P")) {
			Position m = new Position();
			m.setName(df.getName());
			dao.add(m);
		}
		
		
		return null;
	}

}
