package com.zyy.struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyy.beans.User;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpSession session = servletRequest.getSession();
		User u = (User)session.getAttribute("loginUser");
		if(u==null) {
			System.out.println("ÓÃ»§Î´µÇÂ¼...!!");
			HttpServletResponse servletResponse = (HttpServletResponse)response;
			servletResponse.sendRedirect("/Struts_Project/Login.jsp");
		}
		
	}

}
