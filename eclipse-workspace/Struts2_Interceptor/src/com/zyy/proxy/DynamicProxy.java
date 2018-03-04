package com.zyy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DynamicProxy implements InvocationHandler{

	Logger logger = Logger.getLogger(this.getClass().getName());
	Object delegate;
	
	public Object bind(Object delegate) { //被代理类和代理类绑定在一起，类似于构造方法
		this.delegate = delegate;
		//(1.；类加载器 2.delegate接口 3.就是此处实现的类)
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}
	
	//调用delete方法时，此方法会被自动调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		logger.log(Level.INFO, "删除之前~~~");
		System.out.println("proxy:"+proxy.getClass().getName());
		System.out.println("method:"+method.getName());
		
		if(args != null && args.length > 0) {
			for(int i = 0; i < args.length; i++) {
			System.out.println("args["+i+"]:"+ args[i]);
			}
		}
		System.out.println("------------------------");
		
		Object obj = method.invoke(delegate, args);//根据反射机制来调用目标方法
		
		logger.log(Level.INFO, "删除之后~~~");
		//String log = "方法"+method.getName()+"被"+args[0]+"执行";
		//logger.log(Level.INFO, log);
		return obj;
	}

	
}
