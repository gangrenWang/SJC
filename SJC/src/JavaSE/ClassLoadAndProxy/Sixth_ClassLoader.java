package JavaSE.ClassLoadAndProxy;


public class Sixth_ClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s  =""; 
		// 获取 自定义类 类加载器 
	 ClassLoader classLoader = Sixth_ClassLoader.class.getClassLoader();
	  System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@1a28362 
	  
	  //获取 AppClassLoader 的  父类加载器  
	  ClassLoader parent = classLoader.getParent();
	  System.out.println(parent); //sun.misc.Launcher$ExtClassLoader@5fcf29 
	  
	  // 获取 ExtClassLoader 的父类加载器 
	  ClassLoader parent2 = parent.getParent();
	  
	  System.out.println(parent2); //null   
	  
	  // 如果一个类,获取类加载器是 为null,说明  bootStrapClassLoader加载的 
	  ClassLoader classLoader2 = String.class.getClassLoader();
	  
	  System.out.println(classLoader2);
	

	}

}
