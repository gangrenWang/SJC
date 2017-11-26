package JavaSE.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Demo_01 {

	public static void main(String[] args) throws Exception {
		System.out.println(HYGetConnection.getConnection());
		// 获取连接对象
		// method01();
		// method02();
		// method03();
		// method04();
	}
	// a.查询：brand为“晨光”的记录，将所有字段信息打印到控制台上；
	public static void method01() throws Exception {
		Connection ct = HYGetConnection.getConnection();
		String SQLString = "SELECT * FROM Stationery_tb WHERE brand = '晨光'";
		Statement st = (Statement) ct.createStatement();
		ResultSet set = st.executeQuery(SQLString);
		while (set.next()) {
			System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getFloat(3) + " " + set.getInt(4)
					+ " " + set.getString(5));
		}
		st.close();
		set.close();
		ct.close();
	}
	// b.按照目前的库存来计算出“中华铅笔”的价值总额；
	public static void method02() throws SQLException {
		String sql = "SELECT price*stock FROM Stationery_tb WHERE name = '中华铅笔'";
		Connection ct = HYGetConnection.getConnection();
		Statement st = (Statement) ct.createStatement();
		ResultSet set = st.executeQuery(sql);
		while (set.next()) {
			System.out.println(set.getString(1));
		}
		st.close();
		set.close();
		ct.close();
	

	}

	// c. 将表中name为“真彩水性笔”对应的记录的品牌修改为“真彩”;
	static void method03() throws SQLException {
		Connection ct = HYGetConnection.getConnection();
		Statement st = (Statement) ct.createStatement();
		//
		String SQLString = "UPDATE Stationery_tb SET brand = '真彩' WHERE name = '真彩水性笔'";
		int a = st.executeUpdate(SQLString);
		if (a > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
		st.close();
		ct.close();
	}

	// d. 新增记录：id: 6、name:直尺、price: 2、stock：40、brand:得力
	static void method04() throws SQLException {
		Connection ct =  HYGetConnection.getConnection();
		String sql = "INSERT INTO Stationery_tb(id,name,price,stock) values(?,?,?,?)";
		PreparedStatement st = (PreparedStatement) ct.prepareStatement(sql);
		st.setInt(1, 6);
		st.setString(2, "直尺");
		st.setFloat(3, 2);
		st.setInt(4, 40);
		st.setString(5, "得力");
		int a = st.executeUpdate();
		if (a > 0) {
			System.out.println("插入成功");
		}
		st.close();
		ct.close();
	}
}

