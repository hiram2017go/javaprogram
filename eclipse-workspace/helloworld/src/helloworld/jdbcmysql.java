package helloworld;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;



public class jdbcmysql {

	//JDBC 驱动器名称 和 数据库地址
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//数据库的名称为shopping
	static final String DB_URL = "jdbc:mysql://10.32.10.228/shopping?useSSL=false";
	
	static final String User = "root";
	static final String Pass = "123456";*/
		
	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		try
		{
		// TODO Auto-generated method stub
		System.out.println("这是在测试");
		//注册jdbc驱动程序。在一些应用中，无法事先知道使用者将加载什么类，而必须让使用者指定类名称以加载类，可以使用 Class 的静态 forName() 方法实现动态加载类。
		//Class.forName("com.mysql.jdbc.Driver");//貌似去掉也没影响
		System.out.println("创建mysql数据库连接");
		conn =  DBHelper.getConnection();//DriverManager.getConnection(DB_URL, User, Pass);
		System.out.println("执行查询...");
		
		stmt = conn.createStatement(); //ParperStatement 提高代码可读性,可以通过???传入SQL语句后，通过setstring添加，相当于C#的参数化
		String sql = "select * from items";		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			
			System.out.print("id:"+id);
			System.out.print("name:"+name);
			System.out.print("price:"+price);
			System.out.println();
		}
		rs.close();
		System.out.println("执行结束！");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally
		{
			try{
				if(stmt != null) stmt.close();
			}catch(SQLException se) {
				
			}
			try {
				if(conn != null) conn.close();				
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Good Bye!");
	}
}
