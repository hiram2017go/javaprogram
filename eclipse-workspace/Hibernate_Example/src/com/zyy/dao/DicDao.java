package com.zyy.dao;

import java.util.List;

import com.zyy.bean.Dic;

public interface DicDao {

	public void add(Dic d);
	public List listAll();
	public List listMajor();
	public List listRegion();
	public List ListPosition();
}
