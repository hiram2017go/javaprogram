package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAfterAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@AfterReturning("execution(* com.zyy.dao.UserDao.*(..))")
	public void afterReturning(){		
		logger.log(Level.INFO, "delete after.......");
	}

}
