package javaSEJQ.com.itheima.www;

import org.junit.After;
import org.junit.Test;


public class Fourth_JUnit {
/*
 * 注解：代码级别的说明。
 * 1.不能有参数和返回值、不能是静态方法、类名不能是Test
 * 2.一个类中有多个注解时所有方法一起执行，选中方法名单独执行
 * 3.不能再有 有参构造的 类中使用注解。
 * 4.不同的注解传递给虚拟机的信息是不一样的
 */
	private String name;

	public Fourth_JUnit() {
		super();
		;
	}
	@Test 
	public  void method01(){
		System.out.println("test01");
		
	}
	@After 
	public  void method02(){
		System.out.println("test02");
		
	}
	@Test 

	public  void method03(){
		System.out.println("test03");
		
	}
}
