package cn.itcast.Dome;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/*当前工程根目录下创建data.txt文件。提示用户键盘输入一个字符串，
利用字符输出流往文件中写入接收到的内容。然后将文件中的内容读取出来，
从读取出的内容中随机获取3次字符（随机获取的字符可以重复）
，拼接成一个新的字符串，并将新字符串打印到控制台。 */
import java.util.Scanner;


public class Test05 {
	public static void main(String[] args) throws IOException {
		Scanner r = new Scanner(System.in);
		System.out.println("请输入一串字符");
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

