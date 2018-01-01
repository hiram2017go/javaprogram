package com.zyy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {

	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pass = null;
	
	private Connection conn;
	
	static {
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(path+"DBConfig.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			pass = prop.getProperty("password");
//			System.out.println("看看看，加载驱动咯！"+path+"driver="+driver+":url"+ url +user+pass);
			Class.forName(driver); //加载驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DBHelper() {
		System.out.println("DBHelper");
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(path+"DBConfig.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			pass = prop.getProperty("password");
//			System.out.println("看看看，加载驱动咯！"+path+"driver="+driver+":url"+ url +user+pass);
			Class.forName(driver); //加载驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void Close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------");
		try {
			Connection conn = new DBHelper().getConnection();
			if(conn!=null)
			   {
				   System.out.println("数据库连接正常！!!!");
			   }
			   else
			   {
				   System.out.println("数据库连接异常！");
			   }
		}catch(Exception ex) {
			
		}
		finally {
			new DBHelper().Close();
		}
	}
	
}
