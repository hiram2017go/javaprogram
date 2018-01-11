package com.zyy.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.zyy.beans.Meal;
import com.zyy.beans.User;
import com.zyy.dao.OrderDao;
import com.zyy.dao.impl.OrderDaoImpl;
import com.zyy.struts.form.OrderForm;

public class OrderAction extends DispatchAction {

	public ActionForward prepared(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		List list = dao.mealTypeList();
		if(list != null) {
			System.out.println("已经获取到了订餐类型");
			HttpSession session = request.getSession();
			session.setAttribute("MealTypeSession", list);
		}
		
		return mapping.getInputForward();
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用了add方法了");
		OrderForm orderForm = (OrderForm)form;
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		Meal meal = new Meal();
		meal.setUserID(user.getId());
		meal.setDetail(orderForm.getDetail());
		meal.setMealTypeID(orderForm.getMealTypeID());
		meal.setNum(orderForm.getNum());
		meal.setOrderTime(new Date().toLocaleString());
		OrderDao dao = new OrderDaoImpl();
		dao.add(meal);
		return list(mapping, form, request, response);
	}	
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用了list方法了");
		OrderForm orderForm = (OrderForm)form;
		OrderDao dao = new OrderDaoImpl();
		List list = dao.mealList();
		request.setAttribute("MealList", list);
		return prepared(mapping, form, request, response);
	}
}
