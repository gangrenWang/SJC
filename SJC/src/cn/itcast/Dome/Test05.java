package cn.itcast.Dome;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/*��ǰ���̸�Ŀ¼�´���data.txt�ļ�����ʾ�û���������һ���ַ�����
�����ַ���������ļ���д����յ������ݡ�Ȼ���ļ��е����ݶ�ȡ������
�Ӷ�ȡ���������������ȡ3���ַ��������ȡ���ַ������ظ���
��ƴ�ӳ�һ���µ��ַ������������ַ�����ӡ������̨�� */
import java.util.Scanner;


public class Test05 {
	public static void main(String[] args) throws IOException {
		Scanner r = new Scanner(System.in);
		System.out.println("������һ���ַ�");
		String str = r.next();
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
		bw.write(str);
		bw.close();
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String line = null;
		while((line=br.readLine())!=null){
			Random r1 = new Random();
			String s = "";
			int index = r1.nextInt(str.length());
				s += str.charAt(index);
			
			
				br.close();
		}
			System.out.println(str.toString());
	}
	}

