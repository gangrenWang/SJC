package javaSEJQ.com.itheima.www;

import org.junit.After;
import org.junit.Test;


public class Fourth_JUnit {
/*
 * ע�⣺���뼶���˵����
 * 1.�����в����ͷ���ֵ�������Ǿ�̬����������������Test
 * 2.һ�������ж��ע��ʱ���з���һ��ִ�У�ѡ�з���������ִ��
 * 3.�������� �вι���� ����ʹ��ע�⡣
 * 4.��ͬ��ע�⴫�ݸ����������Ϣ�ǲ�һ����
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
