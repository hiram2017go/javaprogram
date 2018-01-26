package com.zyy.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {

		//�˴��ж���û�е�¼�����û�е�¼���ص�¼������Ѿ���¼�ˣ��Ǿ������ɹ�ҳ��
		
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		String username = (String)session.get("loginUser");
		if(username == null) {
			session.put("tip", "��û�е�¼�����ȵ�¼��ʹ�ðɣ�����");
			return "login";
		}else {
			return ai.invoke();
		}
	}
}
