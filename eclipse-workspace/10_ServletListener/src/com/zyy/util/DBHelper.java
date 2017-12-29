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
		//java���þ�̬����ʱ������ù��캯��
		//��̬��������̬��ʼ����>��������ʼ����>������(�о�̬����ʱ���ȳ�ʼ��)			
		System.out.println("���캯�����������ļ�");
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
	
	//��̬���븺���������
	static {
		try {
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();//������buildλ��
			Properties pop = new Properties();	
			pop.load(new FileInputStream(path+"DBConfig.properties"));
			 driver = pop.getProperty("driver");
			 url = pop.getProperty("url");
			 User = pop.getProperty("username");
			 Pass = pop.getProperty("password");	
			System.out.println("��������������������"+path+"driver="+driver+":url"+ url +Pass+User);
			Class.forName(driver);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
	public static  Connection getConnection() {
		System.out.println("���ݿ�connection���ӣ�"+url+User+Pass);
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
				   System.out.println("���ݿ�����������!!!");
			   }
			   else
			   {
				   System.out.println("���ݿ������쳣��");
			   }
			
			CustomerImpl cl = new CustomerImpl();
//			try {
//				cl.Save(c);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			//��������ݲ���
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
