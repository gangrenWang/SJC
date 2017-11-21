package JavaSE.ClassLoadAndProxy;


public class Sixth_ClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s  =""; 
		// ��ȡ �Զ����� ������� 
	 ClassLoader classLoader = Sixth_ClassLoader.class.getClassLoader();
	  System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@1a28362 
	  
	  //��ȡ AppClassLoader ��  ���������  
	  ClassLoader parent = classLoader.getParent();
	  System.out.println(parent); //sun.misc.Launcher$ExtClassLoader@5fcf29 
	  
	  // ��ȡ ExtClassLoader �ĸ�������� 
	  ClassLoader parent2 = parent.getParent();
	  
	  System.out.println(parent2); //null   
	  
	  // ���һ����,��ȡ��������� Ϊnull,˵��  bootStrapClassLoader���ص� 
	  ClassLoader classLoader2 = String.class.getClassLoader();
	  
	  System.out.println(classLoader2);
	

	}

}
