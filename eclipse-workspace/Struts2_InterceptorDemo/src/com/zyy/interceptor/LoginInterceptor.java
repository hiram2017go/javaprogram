package com.zyy.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	
	private String value;
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {

		//此处判断有没有登录，如果没有登录跳回登录，如果已经登录了，那就跳到成功页面
		System.out.println("value="+value);
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		String username = (String)session.get("loginUser");
		if(username == null) {
			session.put("tip", "你没有登录啊，先登录再使用吧！！！");
			return "login";
		}else {
			return ai.invoke();
		}
	}
}
