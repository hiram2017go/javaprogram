package com.zyy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zyy.bean.User;
import com.zyy.dao.UserDao;
import com.zyy.dao.impl.UserDaoImpl;

public class RegisterAction extends ActionSupport {

	private String name;
	private String password;
	private String fullname;
	private String tip;
		
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public String execute() throws Exception {

		UserDao uDao = new UserDaoImpl();
		if(uDao.check(name)) {
			return INPUT;
		}else {
			User u = new User();
			u.setName(name);
			u.setPassword(password);
			u.setFullname(fullname);
			
			uDao.register(u);
			
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.put("loginUser", u);
			
			return SUCCESS;
		}
	}
}
