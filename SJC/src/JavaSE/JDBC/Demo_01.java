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

		// 获取连接对象
		method01();
		// method02();
		// method03();
		// method04();
	}
	// a.查询：student表的所有信息；
	public static void method01() throws Exception {
		Connection ct = HYGetConnection.getConnection();
		String SQLString = "SELECT * FROM student";
		java.sql.Statement st =  ct.createStatement();
		ResultSet set = st.executeQuery(SQLString);
		//利用反射获取StuTable类中所有字段
		
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
	

	// c. 将表中examTeacher为“王刚韧”的对应记录，成绩改为65”;
	static void method03() throws Exception {
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

	// d. 新增记录
	static void method04() throws Exception {
		//控制台输入
		Scanner sc = new Scanner(System.in);
		//创建一个map准备存放从控制台接收的数据
		HashMap<String, Object>map = new HashMap<>();
		//循环录入
		for(int i =0;i<stuFiledArr.length;i++){
			String temFiledName = stuFiledArr[i].getName();
			//id是自增的，不用用户输入
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
			//避开id这个字段
			st.setObject(i+1, map.get(stuFiledArr[i+1].getName()));
		}
		int a = st.executeUpdate();
		if (a > 0) {
			System.out.println("插入成功");
		}
		HYGetConnection.closeALL(null, st, ct);
	}
}

