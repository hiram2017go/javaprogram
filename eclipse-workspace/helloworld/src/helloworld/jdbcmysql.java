package helloworld;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;



public class jdbcmysql {

	//JDBC ���������� �� ���ݿ��ַ
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//���ݿ������Ϊshopping
	static final String DB_URL = "jdbc:mysql://10.32.10.228/shopping?useSSL=false";
	
	static final String User = "root";
	static final String Pass = "123456";*/
		
	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		try
		{
		// TODO Auto-generated method stub
		System.out.println("�����ڲ���");
		//ע��jdbc����������һЩӦ���У��޷�����֪��ʹ���߽�����ʲô�࣬��������ʹ����ָ���������Լ����࣬����ʹ�� Class �ľ�̬ forName() ����ʵ�ֶ�̬�����ࡣ
		//Class.forName("com.mysql.jdbc.Driver");//ò��ȥ��ҲûӰ��
		System.out.println("����mysql���ݿ�����");
		conn =  DBHelper.getConnection();//DriverManager.getConnection(DB_URL, User, Pass);
		System.out.println("ִ�в�ѯ...");
		
		stmt = conn.createStatement(); //ParperStatement ��ߴ���ɶ���,����ͨ��???����SQL����ͨ��setstring��ӣ��൱��C#�Ĳ�����
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
		System.out.println("ִ�н�����");
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
