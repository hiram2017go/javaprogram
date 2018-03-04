package com.zyy.aopapi;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{

	Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {

		Method m = mi.getMethod();
		System.out.println("name:"+m.getName());
		logger.log(Level.INFO,"delete before..............................................");
		mi.proceed();
		logger.log(Level.INFO, "delete after ..................................");
		
		return null;
		
	}

	

}
