package com.zyy.dao;

import java.util.List;

import com.zyy.beans.Meal;

public interface OrderDao {

	public List mealTypeList();
	
	public void add(Meal m);
	
	public List mealList();
}
