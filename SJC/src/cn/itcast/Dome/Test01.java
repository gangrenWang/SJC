package cn.itcast.Dome;
/*����whileѭ����ʾ�û�����5�����֣�����û����������������������ѭ��������һֱ��ʾ��
ֱ������5��Ϊֹ,���������¸�ʽ�����*/
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	while(true){   		
    		for (int i = 0; i < 5; i++) {System.out.println("�������" +(i+1)+"����");
    		int n = sc.nextInt();
			if(i%2==0){
				System.out.println();
			}else{break;
    		}	
		}
			
		}}
	}
