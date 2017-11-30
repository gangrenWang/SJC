package JavaSE.JDBC;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	static DataSource ds  = new ComboPooledDataSource();
	
	/*
	 *  获取连接 
	 */
	public static Connection getCon() throws SQLException{
		return  ds.getConnection();
	}
	/*
	 *  获取连接池 
	 */
	public static DataSource getDataSource() {
		return  ds;
	}
}
