package com.zyy.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zyy.action.LoginAction;

public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		LoginAction loginAction = (LoginAction)ai.getAction();
		System.out.println("≤‚ ‘¿πΩÿ∆˜°£°£°£°£°£°£");
		
		String str = ai.invoke();
		
		System.out.println(loginAction.getName());
		
		System.out.println("------"+str);
		return str;
	}

}
