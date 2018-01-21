package com.zyy.dao;

import com.zyy.bean.SystemMember;

public interface SystemMemberDao {

	public SystemMember login(String username, String password);
	public boolean check(String username);
	public void register(SystemMember sm);
}
