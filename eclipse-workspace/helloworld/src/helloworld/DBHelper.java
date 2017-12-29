package helloworld;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


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
			Class.forName(driver);
			System.out.println("��������������������"+url);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
	public static  Connection getConnection() throws Exception {
		System.out.println("���ݿ�connection���ӣ�"+url+Pass+User);
		if(conn == null) {
			conn = DriverManager.getConnection(url, User, Pass);
		}		
		return conn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------");
		try {
			Connection conn = DBHelper.getConnection();
			if(conn!=null)
			   {
				   System.out.println("���ݿ�����������");
			   }
			   else
			   {
				   System.out.println("���ݿ������쳣��");
			   }
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

}
