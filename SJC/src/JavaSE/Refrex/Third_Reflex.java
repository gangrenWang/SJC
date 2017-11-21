package JavaSE.Refrex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat.Field;
import java.util.ArrayList;

/*
 * 反射
 * 一.获取类的方法：1.对象.getClass()   2.类名.class    3.Class.from("类名")
 * 二.获取构造方法，创建对象
 * 三.获取字段
 * 四.获取方法
 * 五.一个例子，获取ArrayList类实现绕过泛型添加元素
 * 六.解析配置文件信息。没搞。。
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
		System.out.println("这是学生的私有方法");
	}
	
	
	
}
public class Third_Reflex {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Student s = new Student("zhangSan",12);
	//一.获取类
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
		
	//二.获取构造方法。
		//1.获取指定构造方法，需要知道构造方法的参数列表类型
		Constructor<?> cons1 = c2.getConstructor(String.class,int.class);
		//2.通过构造方法实例化对象
		Object obj = cons1.newInstance("zhangSan",18);
		System.out.println(obj.getClass());
		//3.获取私有的构造方法
		Constructor<?>cons2 = c2.getDeclaredConstructor(int.class);
		System.out.println("cons2:"+cons2);
		//4.打开权限
		cons2.setAccessible(true);
		Object obj2 = cons2.newInstance(12);
		//5.打印对象信息
		System.out.println(obj2.toString());
		//6.获取类的所有构造方法getDeclaredConstructors()，获取类的所有非私有构造方法getConstructors()
		Constructor<?>[] cons = c2.getDeclaredConstructors();
		for(int i=0;i<cons.length;i++){
			System.out.println("Student类的所有构造方法："+cons[i]);
		}
		
	//三.获取字段(属性)
		//1.（通过Field类创建Field对象，类.getDeclaredField()方法对应字段）
		java.lang.reflect.Field name_field = c2.getDeclaredField("name");
		java.lang.reflect.Field age_field = c2.getDeclaredField("age");
		//2.通过Field对象给对象字段赋值
		Object tempStu = c2.newInstance();
		//3.给对象赋值
		name_field.set(tempStu, "zhangSan");
		age_field.set(tempStu, 18);
		//4.打印查看
		System.out.println(name_field.get(tempStu));
	
	
	//四.获取方法  通过类获取方法对象，方法对象申请权限，传入object对象调用方法。
		Method secrect_method = c2.getDeclaredMethod("secrect");
		secrect_method.setAccessible(true);
		secrect_method.invoke(tempStu);
		
	//利用反射绕过list的泛型添加元素
		reflexTest_list();
	}
	
	public static void reflexTest_list() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		//1.创建一个integer 类型的list
		ArrayList<Integer>list = new ArrayList<>();
		list.add(12);
		list.add(15);
		Class<?> class_arrayList = list.getClass();
		//利用反射获取到list的add 方法，实现添加一个String类型的元素
		Method method_add = class_arrayList.getDeclaredMethod("add",Object.class);
		method_add.setAccessible(true);
		method_add.invoke(list, "hahaha");
		//System.out.println(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
