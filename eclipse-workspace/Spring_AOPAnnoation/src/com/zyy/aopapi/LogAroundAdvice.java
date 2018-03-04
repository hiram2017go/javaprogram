package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAroundAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Around("execution(* com.zyy.dao.UserDao.*(..))")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {

		logger.log(Level.INFO,"delete before#################################");
		pjp.proceed();
		logger.log(Level.INFO, "delete after#################################");
		
		return null;
		
	}

	

}
