package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = request.getRequestURL().toString();
		System.out.println(url);
		
		PrintWriter out = response.getWriter();
		out.println("hello servlet!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
