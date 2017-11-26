package JavaSE.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class HYGetConnection {


	public static Connection getConnection() throws SQLException {
		Connection ct = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wanghy_DB", "root",
				"123456");
		return ct;
	}
}
