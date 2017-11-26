package cn.itcast.Dome;
/*利用while循环提示用户输入5次数字，如果用户输入的数字是奇数则跳出循环，否则一直提示，
直到输入5次为止,并按照以下格式输出：*/
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	while(true){   		
    		for (int i = 0; i < 5; i++) {System.out.println("请输入第" +(i+1)+"数字");
    		int n = sc.nextInt();
			if(i%2==0){
				System.out.println();
			}else{break;
    		}	
		}
			
		}}
	}
