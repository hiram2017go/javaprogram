package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogBeforeAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Before("execution( * com.zyy.dao.UserDao.*(..))")
	public void before(){
		logger.log(Level.INFO, "delete before ...");
		
	}

}
