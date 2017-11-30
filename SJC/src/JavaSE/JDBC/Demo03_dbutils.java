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
	 * QuerryRunner : �ṩ��sql��������API�������Statement
	 * ResultHandler  ���������� BeanListHandler ���ض��󣻾ۺϺ����� scaleHandler����ѯĳЩ�ֶ���ColumnListHandler��MapHandler ����һ����¼ͨ���ֶ�����ֵ����map�С�
	 * @throws SQLException 
	 * 
	 */
	public static void main(String[] args) throws SQLException {
		method03();
	}
	//1.��������
	public static void method01(){
		String[]arr = Teacher.fileds();
		String sql = "INSERT INTO teacher("+ arr[0]+") VALUES("+arr[1]+")";
		System.out.println(sql);
		Object[]parms = {"��ٻ1","Ů",24,"15565527767"};
		try {
			qr.update(sql,parms);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.��ѯ��ֱ�ӷ�װΪ����
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
	
	//2.��ѯĳ���ض��ֶε�ʱ�����ʹ��ColumnListHandler�������н����װ��������
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
