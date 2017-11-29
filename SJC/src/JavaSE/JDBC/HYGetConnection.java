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
	
	//1.ע������
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
	
	//��ȡ���ӻ�ȡ����
	public static Connection getConnection() throws Exception {
		
		//ԭ����ȡ
		//Connection ct = (Connection) DriverManager.getConnection(URL, userName,	passWord);
		
		/*
		//ͨ��dbcp��ȡ����
		Properties pp  = new Properties();
		pp.load(new FileInputStream("src\\dbcp.properties"));
		System.out.println(pp);
		 //  ͨ�������� �������ӳ� 
		DataSource ds  = BasicDataSourceFactory.createDataSource(pp);
		// ��ȡ���Ӷ��� 
		java.sql.Connection connection = ds.getConnection()��
		System.out.println("============");
		System.out.println(connection);
		*/
		
		//ͨ��c3p0��ȡ
		Connection ct = (Connection) ds.getConnection();

		return ct;
	}
	
	
	//�ͷ���Դʱ����
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
