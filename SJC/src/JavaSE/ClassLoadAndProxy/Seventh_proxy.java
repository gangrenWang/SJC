package JavaSE.ClassLoadAndProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Seventh_proxy {

	private static final int ArrayList = 0;

	/**
	 * 1.����
	 * 
	 */
	public static void main( String[] args) {
		/*
		ArrayList<String>list = new ArrayList<>();
		list.add("123");
		list.add("456");
		List<String> list2 = Collections.unmodifiableList(list);
		list.add("qaz");
		list.add("cv");
		System.out.println(list2);
		*/
		/*
		 * ClassLoader loader : �����������ǰ��ļ�����
		 * Class<?> interfaces interfaces : ��������Ķ�������нӿ�
		 * InvocationHandler h: ��������󣬸��ߴ����࣬��δ�������ķ�����
		 */
		
		final ArrayList<String> list2 = new ArrayList<>();
		list2.add("11");
		list2.add("2");
		list2.add("23");
		List p = (List)Proxy.newProxyInstance(Seventh_proxy.class.getClassLoader(),ArrayList.class.getInterfaces(), new InvocationHandler() {
			@Override
			/*
			 * p: �������
			 * arg1����ǰ���õķ���
			 * arg2:�����Ĳ���
			 * 
			 */
			public Object invoke(Object p, Method arg1, Object[] arg2)
					throws Throwable {
				if(arg1.getName().equals("add")){
					System.out.println("sorry canot add...");
					return false;
				}
				return arg1.invoke(list2, arg2);
			}
		}); 
		System.out.println(p.add("aa"));
		System.out.println(p.get(1));
	}

}
