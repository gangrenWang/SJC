package JavaSE.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
public class HYGetConnection {
	
	//1.注册驱动
		static {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

	private final static String URL = "jdbc:mysql://127.0.0.1:3306/itheima";
	private final static String userName = "root";
	private final static String passWord = "root";
	
	
	
	static DataSource ds  = new ComboPooledDataSource();
	
	//获取连接获取连接
	public static Connection getConnection() throws Exception {
		
		//原生获取
		//Connection ct = (Connection) DriverManager.getConnection(URL, userName,	passWord);
		
		/*
		//通过dbcp获取连接
		Properties pp  = new Properties();
		pp.load(new FileInputStream("src\\dbcp.properties"));
		System.out.println(pp);
		 //  通过工厂类 创建连接池 
		DataSource ds  = BasicDataSourceFactory.createDataSource(pp);
		// 获取连接对象 
		java.sql.Connection connection = ds.getConnection()；
		System.out.println("============");
		System.out.println(connection);
		*/
		
		//通过c3p0获取
		Connection ct = (Connection) ds.getConnection();

		return ct;
	}
	
	
	//释放资源时调用
	public static void closeALL(ResultSet rs, Statement st, Connection c)  {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (st != null) {
				st.close();
			}

			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
