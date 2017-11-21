package JavaSE.Refrex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat.Field;
import java.util.ArrayList;

/*
 * ����
 * һ.��ȡ��ķ�����1.����.getClass()   2.����.class    3.Class.from("����")
 * ��.��ȡ���췽������������
 * ��.��ȡ�ֶ�
 * ��.��ȡ����
 * ��.һ�����ӣ���ȡArrayList��ʵ���ƹ��������Ԫ��
 * ��.���������ļ���Ϣ��û�㡣��
 */

class Student{
	
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private Student( int age) {
		super();
		//this.name = name;
		this.age = age;
	}
	public Student( ) {
		super();
		//this.name = name;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	private void secrect(){
		System.out.println("����ѧ����˽�з���");
	}
	
	
	
}
public class Third_Reflex {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Student s = new Student("zhangSan",12);
	//һ.��ȡ��
		//1.ͬ�������ȡ
		Class c = s.getClass();
		//2.ͨ��������ȡ
		Class c1 = Class.forName("javaSEJQ.com.itheima.www.Student");
		//3.����.class
		Class c2 = Student.class;
		//4.��ӡ�鿴
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		
	//��.��ȡ���췽����
		//1.��ȡָ�����췽������Ҫ֪�����췽���Ĳ����б�����
		Constructor<?> cons1 = c2.getConstructor(String.class,int.class);
		//2.ͨ�����췽��ʵ��������
		Object obj = cons1.newInstance("zhangSan",18);
		System.out.println(obj.getClass());
		//3.��ȡ˽�еĹ��췽��
		Constructor<?>cons2 = c2.getDeclaredConstructor(int.class);
		System.out.println("cons2:"+cons2);
		//4.��Ȩ��
		cons2.setAccessible(true);
		Object obj2 = cons2.newInstance(12);
		//5.��ӡ������Ϣ
		System.out.println(obj2.toString());
		//6.��ȡ������й��췽��getDeclaredConstructors()����ȡ������з�˽�й��췽��getConstructors()
		Constructor<?>[] cons = c2.getDeclaredConstructors();
		for(int i=0;i<cons.length;i++){
			System.out.println("Student������й��췽����"+cons[i]);
		}
		
	//��.��ȡ�ֶ�(����)
		//1.��ͨ��Field�ഴ��Field������.getDeclaredField()������Ӧ�ֶΣ�
		java.lang.reflect.Field name_field = c2.getDeclaredField("name");
		java.lang.reflect.Field age_field = c2.getDeclaredField("age");
		//2.ͨ��Field����������ֶθ�ֵ
		Object tempStu = c2.newInstance();
		//3.������ֵ
		name_field.set(tempStu, "zhangSan");
		age_field.set(tempStu, 18);
		//4.��ӡ�鿴
		System.out.println(name_field.get(tempStu));
	
	
	//��.��ȡ����  ͨ�����ȡ�������󣬷�����������Ȩ�ޣ�����object������÷�����
		Method secrect_method = c2.getDeclaredMethod("secrect");
		secrect_method.setAccessible(true);
		secrect_method.invoke(tempStu);
		
	//���÷����ƹ�list�ķ������Ԫ��
		reflexTest_list();
	}
	
	public static void reflexTest_list() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		//1.����һ��integer ���͵�list
		ArrayList<Integer>list = new ArrayList<>();
		list.add(12);
		list.add(15);
		Class<?> class_arrayList = list.getClass();
		//���÷����ȡ��list��add ������ʵ�����һ��String���͵�Ԫ��
		Method method_add = class_arrayList.getDeclaredMethod("add",Object.class);
		method_add.setAccessible(true);
		method_add.invoke(list, "hahaha");
		//System.out.println(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
