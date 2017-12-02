package JavaSE.NetWorkTCP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



/*
 *   �ļ��ϴ��Ŀͻ��� .  
 *   OutputStream getOutputStream()  ��ȡ����� , ������д������������ 
 *   InputStream  getInputStream()  ��ȡ������������������Ӧ������.�� 
 *   
 */
public class TCP_Client {
	public static void main(String[] args) throws Exception {
		System.out.println("�ͻ�������... ");
		// ��ȡ������
		FileInputStream fis = new FileInputStream("data.txt");
		// ���� Scoket ( �Է� ip, �Է�����Ķ˿� )
		Socket socket = new Socket(InetAddress.getLocalHost(), 5556);
		// ��ȡ��
		OutputStream os = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		// ��д����
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		
		socket.shutdownOutput();
		while(true){
		System.out.println("���ݷ������");
		byte[]buf = new byte[1024];
		len = in.read(buf);
		String str = new String(buf,0,len);
		
		System.out.println(str);
		if(str!=null){
			socket.close();
			os.close();
			fis.close();
			break;
		}
		}
		
		
		
	}
}
