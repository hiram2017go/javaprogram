package com.servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorldServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getRequestURL().toString();
		System.out.println(url);
		
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
