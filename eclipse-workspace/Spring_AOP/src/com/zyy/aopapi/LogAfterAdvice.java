package com.zyy.aopapi;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterAdvice implements AfterReturningAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void afterReturning(Object returnVal, Method m, Object[] args, Object obj) throws Throwable {

		System.out.println("returnval="+returnVal);
		if(args.length > 0) {
			System.out.println("²ÎÊý0="+args[0]);
		}
		System.out.println("method="+m.getName());
		System.out.println("obj="+obj.toString());
		
		logger.log(Level.INFO, "delete after.......");
	}

}
