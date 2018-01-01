package com.zyy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zyy.bean.CollectionBean;
import com.zyy.dao.CollDao;
import com.zyy.util.DBHelper;

public class CollDaoImpl implements CollDao {

	@Override
	public void save(CollectionBean ben) {
		// TODO Auto-generated method stub
		String sql = "insert into collectiontbl (name,url) values (?,?)";
		Connection conn =  new DBHelper().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ben.getName());
			pstmt.setString(2, ben.getUrl());
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
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

	@Override
	public void update(CollectionBean ben) {
		// TODO Auto-generated method stub
		String sql = "update collectiontbl set name = ?,url =? where id = ?";
		Connection conn =  new DBHelper().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ben.getName());
			pstmt.setString(2, ben.getUrl());
			pstmt.setInt(3, ben.getId());
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		String sql = "delete from collectiontbl where id = ?";
		Connection conn = new DBHelper().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(String id : ids) {
			pstmt.setInt(1, new Integer(id));
			pstmt.executeUpdate();
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public CollectionBean get(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from collectiontbl where id = ?";
		Connection conn =  new DBHelper().getConnection();
		List list = new ArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				CollectionBean bean = new CollectionBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setUrl(rs.getString(3));
				return bean;
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		String sql = "select * from collectiontbl ";
		Connection conn =  new DBHelper().getConnection();
		List list = new ArrayList();
		try {
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String url = rs.getString(3);
				
				CollectionBean bean = new CollectionBean();
				bean.setId(id);
				bean.setName(name);
				bean.setUrl(url);
				
				list.add(bean);
			}
			
			return list;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
