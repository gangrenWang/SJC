package javaSEJQ.com.itheima.www;

public class Sixth_ClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ȡ�Զ�������������
		  ClassLoader cl = Sixth_ClassLoader.class.getClassLoader();
		  System.out.println(cl);
		  ClassLoader c2 = cl.getParent();
		  System.out.println(c2);
		  ClassLoader c3 = c2.getParent();
		  System.out.println(c3);
	

	}

}
