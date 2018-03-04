package com.zyy.aopapi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogBeforeAdvice{

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void before() throws Throwable {

		logger.log(Level.INFO, "delete before ...");
		
	}

}
