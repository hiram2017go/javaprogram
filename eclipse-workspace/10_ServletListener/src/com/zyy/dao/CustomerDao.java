package com.zyy.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyy.beans.Customer;

public interface CustomerDao {
	
	public void Save(Customer c);
	
	public List list();
}
