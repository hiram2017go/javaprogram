package com.zyy.dao;

import java.util.List;

import com.zyy.bean.CollectionBean;

public interface CollDao {

	public void save(CollectionBean ben);
	
	public void update(CollectionBean ben);
	
	public void delete(String[] ids);
	
	public CollectionBean get(int id);
	
	public List list();
	
}
