package com.zyy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.zyy.beans.User;
import com.zyy.dao.UserDao;
import com.zyy.util.DBHelper;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "insert into usertbl (name,fullName,password) values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getFullName());
			stmt.setString(3, u.getPassword());
			
			stmt.executeUpdate();
		}catch(Exception ex) {
			
		}finally {
			dbHelper.Close(conn);
		}
	}

	@Override
	public Boolean check(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from usertbl where name = ?";
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(Exception ex) {
			System.out.println("查询用户是否存在时出错了:"+ ex.getMessage());
		}finally {
			dbHelper.Close(conn);
		}
		
		return false;
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select id,name,password,fullname,privillage from usertbl where name = ? and password=?";
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String fullName = rs.getString(4);
				String privillage = rs.getString(5);
				
				User u = new User();
				u.setFullName(fullName);
				u.setId(id);
				u.setName(username);
				u.setPassword(password);
				u.setPrivillage(privillage);
				
				return u;
			}
		}catch(Exception ex) {
			System.out.println("出错了："+ex.getMessage());
		}finally {
			dbHelper.Close(conn);
		}		
		return null;
	}

}
