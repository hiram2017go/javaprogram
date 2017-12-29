package com.zyy.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;

public class BasicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		System.out.println("doGet");
		
		if(request.getParameter("username") == "hello") {
			//�����ض���
			response.sendRedirect("url");
			//����ת��
			request.getRequestDispatcher("url").forward(request, response);
			//������� 
			request.getRequestDispatcher("url").include(request, response);
			
			//request.getParameterNames();
			//request.getHeaderNames();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		System.out.println("doPost");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}
}
