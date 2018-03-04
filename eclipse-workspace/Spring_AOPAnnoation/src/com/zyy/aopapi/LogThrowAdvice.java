package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogThrowAdvice{

	Logger logger = Logger.getLogger(this.getClass().getName());
	@AfterThrowing("execution(* com.zyy.dao.UserDao.*(..))")
	public void afterThrowing() {		
		logger.log(Level.INFO, "Throws ...............................");
		
	}
	
}
