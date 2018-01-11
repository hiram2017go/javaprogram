package com.zyy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zyy.beans.Meal;
import com.zyy.beans.MealBean;
import com.zyy.beans.MealType;
import com.zyy.dao.OrderDao;
import com.zyy.util.DBHelper;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List mealTypeList() {
		// TODO Auto-generated method stub
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "select id,name,price from mealtype";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List list = new ArrayList();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				MealType mt = new MealType();
				mt.setId(id);
				mt.setName(name);
				mt.setPrice(price);
				
				list.add(mt);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("获取订餐类型出错:"+ex.getMessage());
		}finally {
			dbHelper.Close(conn);
		}
		return null;
	}

	@Override
	public void add(Meal m) {
		// TODO Auto-generated method stub
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "insert into mealtbl (userID,mealTypeID,isPay,detail,num,orderTime) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, m.getUserID());
			stmt.setInt(2, m.getMealTypeID());
			stmt.setInt(3, m.getIsPay());
			stmt.setString(4, m.getDetail());
			stmt.setInt(5, m.getNum());
			stmt.setString(6, m.getOrderTime());
			stmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("添加订餐出错了:"+ex.getMessage());
		}finally {
			dbHelper.Close(conn);
		}		
	}

	@Override
	public List mealList() {
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "select u.fullName,mt.name,m.isPay,m.detail,m.num,mt.price, m.orderTime from mealtbl as m LEFT JOIN mealtype as mt on m.mealTypeID = mt.id left join usertbl as u ON m.userID = u.id";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List list = new ArrayList();
			while(rs.next()) {
				String fullName = rs.getString(1);
				String mealTypeName = rs.getString(2);
				int isPay = rs.getInt(3);
				String detail = rs.getString(4);
				int num = rs.getInt(5);
				int price = rs.getInt(6);
				String orderTime = rs.getString(7);
				
				MealBean m = new MealBean();
				m.setFullName(fullName);
				m.setDetail(detail);
				m.setIsPay(isPay);
				m.setNum(num);
				m.setOrderTime(orderTime);
				m.setMealTypeName(mealTypeName);
				m.setTotal(num * price);
				list.add(m);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("获取订餐列表出错:"+ex.getMessage());
		}finally {
			dbHelper.Close(conn);
		}
		return null;
	}

}
