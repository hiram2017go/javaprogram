package com.zyy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUsers implements ServletContextListener ,HttpSessionListener {

	private int counts;
	private ServletContext ctx = null;

	/* ���������WebӦ�÷����Ƴ���û�������ٽ��������ʱ�򱻵��á�
	 */
	public void contextDestroyed(ServletContextEvent event){
		//Output a simple message to the server's console
		System.out.println("ContextDestoryed...");
		ctx = null;

	}

	// ���������WebӦ�÷������ý��������ʱ�򱻵��á�
	public void contextInitialized(ServletContextEvent event){
		System.out.println("ContextInitialized...");
		ctx = event.getServletContext();
	}

	
	public void sessionCreated(HttpSessionEvent se) { 
		System.out.println("SessionCreated...");
		counts++;
		ctx.setAttribute("counts", counts);
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {  
		System.out.println("SessionDestoryed...");
		counts--;
		ctx.setAttribute("counts", counts);
	}
}
