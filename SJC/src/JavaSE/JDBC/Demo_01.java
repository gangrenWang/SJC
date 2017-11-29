package JavaSE.JDBC;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;



import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Demo_01 {
	
	static Field[]stuFiledArr = StuTable.class.getFields();

	public static void main(String[] args) throws Exception {

		// ��ȡ���Ӷ���
		method01();
		// method02();
		// method03();
		// method04();
	}
	// a.��ѯ��student���������Ϣ��
	public static void method01() throws Exception {
		Connection ct = HYGetConnection.getConnection();
		String SQLString = "SELECT * FROM student";
		java.sql.Statement st =  ct.createStatement();
		ResultSet set = st.executeQuery(SQLString);
		//���÷����ȡStuTable���������ֶ�
		
		while (set.next()) {
			System.out.println("-------------------------------------");
			for(int i =0;i <stuFiledArr.length;i++){
				String tempName = stuFiledArr[i].getName();
				System.out.println(tempName+" : "+set.getObject(tempName));
				
			}
			System.out.println("-------------------------------------");
		}
		HYGetConnection.closeALL(set, st, ct);
		
	}
	

	// c. ������examTeacherΪ�������͡��Ķ�Ӧ��¼���ɼ���Ϊ65��;
	static void method03() throws Exception {
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

	// d. ������¼
	static void method04() throws Exception {
		//����̨����
		Scanner sc = new Scanner(System.in);
		//����һ��map׼����Ŵӿ���̨���յ�����
		HashMap<String, Object>map = new HashMap<>();
		//ѭ��¼��
		for(int i =0;i<stuFiledArr.length;i++){
			String temFiledName = stuFiledArr[i].getName();
			//id�������ģ������û�����
			if(temFiledName.equals("id"))continue;
			System.out.println("please inter "+temFiledName+":");
			map.put(temFiledName, sc.next());
		}
		
		Connection ct =  HYGetConnection.getConnection();
		String filedNames = "";
		String wenHaos = "";
		for(int i =1;i<stuFiledArr.length;i++){
			filedNames= filedNames+stuFiledArr[i].getName();
			wenHaos+="?";
			if(i<stuFiledArr.length-1){
				filedNames+=",";
				wenHaos+=",";
					} 
		}
		String sql = "INSERT INTO student("+filedNames+") values("+wenHaos+")";
		System.out.println(sql);
		PreparedStatement st = (PreparedStatement) ct.prepareStatement(sql);
		for(int i=0;i<map.size();i++){
			//�ܿ�id����ֶ�
			st.setObject(i+1, map.get(stuFiledArr[i+1].getName()));
		}
		int a = st.executeUpdate();
		if (a > 0) {
			System.out.println("����ɹ�");
		}
		HYGetConnection.closeALL(null, st, ct);
	}
}

