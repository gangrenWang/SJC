package JavaSE.JDBC;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewPooledConnection;



public class Demo03_dbutils {

	static QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource() );

	/**
	 * QuerryRunner : 提供对sql语句操作的API，替代了Statement
	 * ResultHandler  处理结果集： BeanListHandler 返回对象；聚合函数用 scaleHandler；查询某些字段用ColumnListHandler；MapHandler 将第一条记录通过字段名和值存入map中。
	 * @throws SQLException 
	 * 
	 */
	public static void main(String[] args) throws SQLException {
		method03();
	}
	//1.插入数据
	public static void method01(){
		String[]arr = Teacher.fileds();
		String sql = "INSERT INTO teacher("+ arr[0]+") VALUES("+arr[1]+")";
		System.out.println(sql);
		Object[]parms = {"刘倩1","女",24,"15565527767"};
		try {
			qr.update(sql,parms);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.查询后直接封装为对象
	public static void method02(){
		//String[]arr = Teacher.fileds();
		String sql = "SELECT * FROM teacher";
		
		try {
			List<Teacher>list = qr.query(sql, new BeanListHandler<>(Teacher.class));
			for (Teacher teacher : list) {
				System.out.println(teacher.tname +" "+teacher.tage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.查询某个特定字段的时候可以使用ColumnListHandler，将所有结果封装到集合中
		public static void method03(){
			//String[]arr = Teacher.fileds();
			String sql = "SELECT * FROM teacher";
			
			try {
				List<Object>list = qr.query(sql, new ColumnListHandler(1));
				for (Object ob : list) {
					System.out.println(ob);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
