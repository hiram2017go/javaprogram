package com.zyy.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {

	public void delete(Object obj);
	
	public Object get(Class cls, Serializable id);
	
	public List list(String hql);
	
	public void save(Object obj);
	
	public void update(Object obj);
}
