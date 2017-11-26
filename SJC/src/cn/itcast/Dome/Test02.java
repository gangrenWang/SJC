package cn.itcast.Dome;
/*定义一个静态方法 void method(int[] arr),输出该数组元素的“总和”以及“平均值”，在main方法中定义一个int型数组，
数组元素有{2,3,5,1,5,2}，并将该数组传入method方法中，调用测试。*/
public class Test02 {
	public static void main(String[] args) {
		int[] arr = {2,3,5,1,5,2};
		method(arr);
	}
	public static void method(int[] arr){
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
			int avg = sum/(arr.length);
			System.out.println("和是"+sum);
			System.out.println("平均值是"+avg);
		}
	}
} 
