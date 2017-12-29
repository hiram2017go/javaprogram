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
			Class.forName(driver);
			System.out.println("看看看，加载驱动咯！"+url);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static  Connection getConnection() throws Exception {
		System.out.println("数据库connection连接！"+url+Pass+User);
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
				   System.out.println("数据库连接正常！");
			   }
			   else
			   {
				   System.out.println("数据库连接异常！");
			   }
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

}
