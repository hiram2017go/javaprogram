package com.zyy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DynamicProxy implements InvocationHandler{

	Logger logger = Logger.getLogger(this.getClass().getName());
	Object delegate;
	
	public Object bind(Object delegate) { //��������ʹ��������һ�������ڹ��췽��
		this.delegate = delegate;
		//(1.��������� 2.delegate�ӿ� 3.���Ǵ˴�ʵ�ֵ���)
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}
	
	//����delete����ʱ���˷����ᱻ�Զ�����
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		logger.log(Level.INFO, "ɾ��֮ǰ~~~");
		System.out.println("proxy:"+proxy.getClass().getName());
		System.out.println("method:"+method.getName());
		
		if(args != null && args.length > 0) {
			for(int i = 0; i < args.length; i++) {
			System.out.println("args["+i+"]:"+ args[i]);
			}
		}
		System.out.println("------------------------");
		
		Object obj = method.invoke(delegate, args);//���ݷ������������Ŀ�귽��
		
		logger.log(Level.INFO, "ɾ��֮��~~~");
		//String log = "����"+method.getName()+"��"+args[0]+"ִ��";
		//logger.log(Level.INFO, log);
		return obj;
	}

	
}
