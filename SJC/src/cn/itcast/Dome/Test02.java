package cn.itcast.Dome;
/*����һ����̬���� void method(int[] arr),���������Ԫ�صġ��ܺ͡��Լ���ƽ��ֵ������main�����ж���һ��int�����飬
����Ԫ����{2,3,5,1,5,2}�����������鴫��method�����У����ò��ԡ�*/
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
			System.out.println("����"+sum);
			System.out.println("ƽ��ֵ��"+avg);
		}
	}
} 
