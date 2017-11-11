package javaSEJQ.com.itheima.www;

import java.lang.reflect.Constructor;

/*
 * 反射
 * 一.获取类的方法：1.对象.getClass()   2.类名.class    3.Class.from("类名")
 * 二.
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
		//1.同过对象获取
		Class c = s.getClass();
		//2.通过类名获取
		Class c1 = Class.forName("javaSEJQ.com.itheima.www.Student");
		//3.类名.class
		Class c2 = Student.class;
		//4.打印查看
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		
		
		Constructor constructor = 
				clz.getConstructor( String.class  ,int.class ) ;
		
	}
}
