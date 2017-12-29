package com.zyy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUsers implements ServletContextListener ,HttpSessionListener {

	private int counts;
	private ServletContext ctx = null;

	/* 这个方法在Web应用服务被移除，没有能力再接受请求的时候被调用。
	 */
	public void contextDestroyed(ServletContextEvent event){
		//Output a simple message to the server's console
		System.out.println("ContextDestoryed...");
		ctx = null;

	}

	// 这个方法在Web应用服务做好接受请求的时候被调用。
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
