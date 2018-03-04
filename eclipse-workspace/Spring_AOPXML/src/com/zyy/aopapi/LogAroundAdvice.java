package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAroundAdvice{

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {


		logger.log(Level.INFO,"delete before######################################");
		pjp.proceed();
		logger.log(Level.INFO, "delete after######################################");
		
		return null;
		
	}
}
