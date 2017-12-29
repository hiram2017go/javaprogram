package com.zyy.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEncoding implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("ÐÞ¸Ä±àÂëÀ´ÁË");
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		chain.doFilter(request, response);
	}

}
