package com.zyy.aopapi;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.ThrowsAdvice;

public class LogThrowAdvice implements ThrowsAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());
	public void afterThrowing(Method m, Object[] arg, Object target, Throwable t) {
		
		System.out.println("m="+m.getName());
		System.out.println("target="+target.toString());
		if(arg.length > 0) {
			System.out.println("²ÎÊý:"+arg[0]);
		}
		
		logger.log(Level.INFO, "Throws ...............................");
		
	}
	
}
