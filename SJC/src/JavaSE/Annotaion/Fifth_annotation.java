package JavaSE.Annotaion;

import java.lang.reflect.Method;
import java.util.ArrayList;



public class Fifth_annotation {

	public static void main(String[] args) throws Exception, SecurityException {
	method02();
	}

	@HYAnnotation(age = 12, username = "sun", arr = { "" })
	public static void main01() throws Exception, SecurityException {
		//1.�õ���ǰ����
		Method me = Fifth_annotation.class.getMethod("main01");
		//2.�жϵ�ǰ�����Ƿ��� HYAnnotation ���͵�ע��
		boolean flag = me.isAnnotationPresent(HYAnnotation.class);
		System.out.println(flag);
		//3.�����
		if (flag) {

			// 1.��ȡ ע��
			HYAnnotation annotation = me.getAnnotation(HYAnnotation.class);
			// 2.��ȡע�������ֵ
			String username = annotation.username();
			int age = annotation.age();

			System.out.println(username);
			System.out.println(age);

		}

	}
	public static void method02(){
		
		ArrayList<String>list = new ArrayList<>();
		@SuppressWarnings({"rawtypes","unused"})
		ArrayList list1 = new ArrayList<>();
		list1.add("123");
		list1.add(2);
		System.out.println(list1.size());
	}
	


}
