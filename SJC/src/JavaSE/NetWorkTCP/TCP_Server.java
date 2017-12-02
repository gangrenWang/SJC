package JavaSE.NetWorkTCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *   TCP Э��  ���� ��Ϣ(�ļ�).   ģ���ļ��ϴ� . 
 *    
 *    �ļ��ϴ��ķ���� .   ServerSocket  ������ֱ�ӻ�ȡ����.  ͨ��accept ���յķ��� ,����socket ,������ȡ������. 
 *    
 *     Socket accept() : �������� . 
 *
 */
public class TCP_Server {
	public static void main(String[] args) throws IOException {
		System.out.println("����������,�ȴ�����.."); 
		// ���� ServerScoket ��
		 ServerSocket ss  = new ServerSocket(5556);
		
		 // ��������
		 Socket accept = ss.accept();
		 
		 //��ȡ������ 
		 InputStream is  = accept.getInputStream();
		 
		 OutputStream fos  = new FileOutputStream("zx.jpg");
		 
		 // ��д����
		 byte[] b  = new byte[1024] ; 
		 int len; 
		 while (( len  = is.read(b))!=-1 ) {
			fos.write(b, 0, len); 
		}
		 //accept.shutdownInput();
		 fos = accept.getOutputStream();
		 fos.write("server���յ�".getBytes());
		 
		 //�ر� 
		 fos.close();
		 is.close();
		 accept.close(); 
		 ss.close(); 
		 
	}
}
