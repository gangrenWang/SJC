package JavaSE.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Demo_01 {

	public static void main(String[] args) throws Exception {
		System.out.println(HYGetConnection.getConnection());
		// ��ȡ���Ӷ���
		// method01();
		// method02();
		// method03();
		// method04();
	}
	// a.��ѯ��brandΪ�����⡱�ļ�¼���������ֶ���Ϣ��ӡ������̨�ϣ�
	public static void method01() throws Exception {
		Connection ct = HYGetConnection.getConnection();
		String SQLString = "SELECT * FROM Stationery_tb WHERE brand = '����'";
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
	// b.����Ŀǰ�Ŀ������������л�Ǧ�ʡ��ļ�ֵ�ܶ
	public static void method02() throws SQLException {
		String sql = "SELECT price*stock FROM Stationery_tb WHERE name = '�л�Ǧ��'";
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

	// c. ������nameΪ�����ˮ�Աʡ���Ӧ�ļ�¼��Ʒ���޸�Ϊ����ʡ�;
	static void method03() throws SQLException {
		Connection ct = HYGetConnection.getConnection();
		Statement st = (Statement) ct.createStatement();
		//
		String SQLString = "UPDATE Stationery_tb SET brand = '���' WHERE name = '���ˮ�Ա�'";
		int a = st.executeUpdate(SQLString);
		if (a > 0) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}
		st.close();
		ct.close();
	}

	// d. ������¼��id: 6��name:ֱ�ߡ�price: 2��stock��40��brand:����
	static void method04() throws SQLException {
		Connection ct =  HYGetConnection.getConnection();
		String sql = "INSERT INTO Stationery_tb(id,name,price,stock) values(?,?,?,?)";
		PreparedStatement st = (PreparedStatement) ct.prepareStatement(sql);
		st.setInt(1, 6);
		st.setString(2, "ֱ��");
		st.setFloat(3, 2);
		st.setInt(4, 40);
		st.setString(5, "����");
		int a = st.executeUpdate();
		if (a > 0) {
			System.out.println("����ɹ�");
		}
		st.close();
		ct.close();
	}
}

