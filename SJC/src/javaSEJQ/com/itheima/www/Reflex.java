package javaSEJQ.com.itheima.www;

import java.lang.reflect.Constructor;

/*
 * ����
 * һ.��ȡ��ķ�����1.����.getClass()   2.����.class    3.Class.from("����")
 * ��.
 */

class Student{
	
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	
}
public class Reflex {

	public static void main(String[] args) throws ClassNotFoundException {
		Student s = new Student("zhangSan",12);
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
		
		
		Constructor constructor = 
				clz.getConstructor( String.class  ,int.class ) ;
		
	}
}
