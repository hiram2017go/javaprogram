package com.zyy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.UserDaoImpl;

public class LoginAction extends ActionSupport {

	private String tip;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String execute() throws Exception {

		
		System.out.println("--------------------------");
		UserDao uDao = new UserDaoImpl();
		
		User user = uDao.login(name, password);
		if(user == null) {
			this.setTip("用户名或密码错误！");
			return INPUT;
		}else {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.put("loginUser", user);
			return SUCCESS;
		}
	}
}
