package cn.itcast.Dome;

import java.util.Scanner;

/*提示键盘录入一个字符串，遍历该字符串中所有字符并判断是否包含小写字母，
如果不包含，则输出“不包含小写字母”；
如果包含，则将包含的所有小写字母输出到控制台。打印如下：*/
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
