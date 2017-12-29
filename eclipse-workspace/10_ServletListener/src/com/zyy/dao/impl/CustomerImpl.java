package com.zyy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zyy.beans.Customer;
import com.zyy.dao.CustomerDao;
import com.zyy.util.DBHelper;

public class CustomerImpl implements CustomerDao {

	public void Save(Customer c){
		Connection conn = DBHelper.getConnection();
		try {
			String sql = "insert into items (name,city) values(?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, c.getName());
			pmst.setString(2, c.getCity());
			pmst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List list(){
		Connection conn = DBHelper.getConnection();
		List list = new ArrayList();
		try {
			String sql = "select * from items";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				Customer c = new Customer();
				c.setCity(city);
				c.setId(id);
				c.setName(name);
				list.add(c);
			}		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
