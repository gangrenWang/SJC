package JavaSE.NetWorkTCP;

import java.io.FileInputStream;
import java.io.IOException;
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
		Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
		// ��ȡ��
		OutputStream os = socket.getOutputStream();

		// ��д����
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		System.out.println("���ݷ������");

		// �ر���Դ

		os.close();
		socket.close();
		fis.close();

	}
}
