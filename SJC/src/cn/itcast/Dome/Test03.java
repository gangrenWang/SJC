package cn.itcast.Dome;

import java.util.Scanner;

/*��ʾ����¼��һ���ַ������������ַ����������ַ����ж��Ƿ����Сд��ĸ��
������������������������Сд��ĸ����
����������򽫰���������Сд��ĸ���������̨����ӡ���£�*/
public class Test03 {
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		String str = r.next();
		for (int i = 0; i <str.length(); i++) {	
			if('a'<(str.charAt(i)) && (str.charAt(i)<'z'){
				String st +=(str.charAt(i));
			}
		}
		
	}
}
