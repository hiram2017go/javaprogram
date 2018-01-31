package com.zyy.aopapi;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void before(Method m, Object[] args, Object obj) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("方法名:"+m.getName());
		if(args.length > 0) {
			System.out.println("参数0"+args[0]);
		}
		System.out.println("应该是操作对象:"+obj.toString()); //com.zyy.dao.impl.UserDaoImpl
		logger.log(Level.INFO, "delete before ...");
		
	}

}
