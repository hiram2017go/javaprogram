package com.zyy.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.zyy.beans.Customer;
import com.zyy.dao.impl.CustomerImpl;


public class DBHelper {
	private static String driver = null;// "com.mysql.jdbc.Driver";
	private static String url = null;// "jdbc:mysql://10.32.10.228/shopping?useSSL=false";
	private static String User = null;//"root";
	private static String Pass = null;//"123456";
	
	private static Connection conn = null;
	
	public DBHelper(){
		//java调用静态函数时不会调用构造函数
		//静态变量、静态初始化块>变量、初始化块>构造器(有静态变量时会先初始化)			
		System.out.println("构造函数加载配置文件");
		Properties pop = new Properties();		
		try {
			pop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			 driver = pop.getProperty("driver");
			 url = pop.getProperty("url");
			 User = pop.getProperty("user");
			 User = pop.getProperty("password");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//静态代码负责加载驱动
	static {
		try {
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();//编译后的build位置
			Properties pop = new Properties();	
			pop.load(new FileInputStream(path+"DBConfig.properties"));
			 driver = pop.getProperty("driver");
			 url = pop.getProperty("url");
			 User = pop.getProperty("username");
			 Pass = pop.getProperty("password");	
			System.out.println("看看看，加载驱动咯！"+path+"driver="+driver+":url"+ url +Pass+User);
			Class.forName(driver);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static  Connection getConnection() {
		System.out.println("数据库connection连接！"+url+User+Pass);
		//if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, User, Pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}		
		return conn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------");
		try {
			Connection conn = DBHelper.getConnection();
			if(conn!=null)
			   {
				   System.out.println("数据库连接正常！!!!");
			   }
			   else
			   {
				   System.out.println("数据库连接异常！");
			   }
			
			CustomerImpl cl = new CustomerImpl();
//			try {
//				cl.Save(c);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			//已完成数据插入
			List list = null;
			try {
				list = cl.list();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0;i < list.size(); i++) {
				Customer cu = (Customer)list.get(i);
				int id = cu.getId();
				String myName = cu.getName();
				String myCity = cu.getCity();
				
				System.out.println("id="+id+";name="+myName+";city="+myCity);
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

}
