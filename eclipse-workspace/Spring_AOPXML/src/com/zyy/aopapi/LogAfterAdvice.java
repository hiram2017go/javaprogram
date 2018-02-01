package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LogAfterAdvice{

	Logger logger = Logger.getLogger(this.getClass().getName());

	public void afterReturning() throws Throwable {
		logger.log(Level.INFO, "delete after.......");
	}
}
