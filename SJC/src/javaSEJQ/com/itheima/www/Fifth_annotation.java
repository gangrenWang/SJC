package javaSEJQ.com.itheima.www;

import java.lang.reflect.Method;



public class Fifth_annotation {

	public static void main(String[] args) throws Exception, SecurityException {
		main01();
	}

	@HYAnnotation(age = 12, username = "sun", arr = { "" })
	public static void main01() throws Exception, SecurityException {
		//1.拿到當前方法
		Method me = Fifth_annotation.class.getMethod("main01");
		//2.判断当前方法是否有 HYAnnotation 类型的注解
		boolean flag = me.isAnnotationPresent(HYAnnotation.class);
		System.out.println(flag);
		//3.如果有
		if (flag) {

			// 1.获取 注解
			HYAnnotation annotation = me.getAnnotation(HYAnnotation.class);
			// 2.获取注解的属性值
			String username = annotation.username();
			int age = annotation.age();

			System.out.println(username);
			System.out.println(age);

		}

	}

}
