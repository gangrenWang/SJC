package JavaSE.JDBC;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	static DataSource ds  = new ComboPooledDataSource();
	
	/*
	 *  ��ȡ���� 
	 */
	public static Connection getCon() throws SQLException{
		return  ds.getConnection();
	}
	/*
	 *  ��ȡ���ӳ� 
	 */
	public static DataSource getDataSource() {
		return  ds;
	}
}
