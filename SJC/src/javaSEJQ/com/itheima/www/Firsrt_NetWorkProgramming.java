package javaSEJQ.com.itheima.www;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.junit.Test;
import org.omg.CORBA.portable.InputStream;
import java.net.DatagramSocket;

/**
 * 
 * @author Sunny
 * @version1.0
 *OSI �ο�ģ�ͣ�����㡢������·�㡢����㡢����㡢�Ự�㡢��ʾ���Ӧ�ò㡣
 * 
 * ������: 
 * ��Ҫ��: 
 *    IP : �������豸��Ψһ��ʶ
 *    �˿�: �豸�г����Ψһ��ʶ
 *    Э��: ���������ݴ���Ĺ���. 
 *    		UDP:����������. �����Ƿ�����,���ᴫ������. ���� �㲥 .  ���ݲ���ȫ ,����Ч�ʸ� . 
 *    			��Ƶֱ��, �绰����.   
 *    		DatagramSocket   , DatagramPacket 
 *    		TCP:��������(��������Э�� ).ȷ�������ӳɹ�,���ܴ�������. ����  ,�ļ����� 99.99%
 * 			Socket  / ServerSocket  
 * 
 * 
 *    https:// www.baidu.com:8080
 *    			ip��ַ:180.149.132.47
 *    
 *    ip��ַ: �����������豸��Ψһ��ʶ 192.168.94.84
 *    �˿�: �����Ψһ��ʶ  ��Χ 0-65535 , ���ָ���Ķ˿� 1024 - 65535 ,���� ���ѱ���������ռ�õĶ˿��ظ�. 
 *
 */
public class Firsrt_NetWorkProgramming {
	public static void main(String[] args) throws IOException {
	
		
		

}
	/*
	 * 01.InetAddress �� IP��ַ����
	 */
	public static void method01() throws IOException{
		InetAddress host = InetAddress.getByName("www.baidu.com");
		//System.out.println(host.getHostAddress());
	}
	
	/*
	 * 02.URL ͳһ��Դ��λ��������URL��ȡ��Ӧ��Դ��
	 */
	public static void method02() throws IOException{
		//URL ͳһ��Դ��λ��
				URL url = new URL("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1062523921,2025672967&fm=173&s=671CEB2A0AB061A5323D32D3030090A0&w=313&h=379&img.JPG");
				String file = url.getFile();
				System.out.println(file);
				//��ȡURL��������
				String tempHost = url.getHost();
				System.out.println(tempHost);
				int port = url.getPort();
				System.out.println(port);
				//��ȡ·��
				String path = url.getPath();
				System.out.println(path);
				//��ȡЭ��
				String protocol = url.getProtocol();
				System.out.println(protocol);
				
				//ʹ��URLconnection��URL��Դ���ص�����
				URLConnection connection = url.openConnection();
				java.io.InputStream is =  connection.getInputStream();
				OutputStream os = new FileOutputStream("/Users/wanggangren/Desktop/hehe.jpg");
				byte[] buffer = new byte[1024];
				int flag = 0;
				while (-1 != (flag = is.read(buffer, 0, buffer.length)))
				{
				     os.write(buffer, 0, flag);
				    }
				os.close();
				is.close();
			}
	/*
	 * 03.UDP_send :DatagramSocket : UDP Э���·��ͺͽ��� ���ݵ���. 
	 */
	public static void method03() throws IOException{
		//1.���� DatagramSocket ����
		DatagramSocket ds = new DatagramSocket();
		//2.���� DatagramPacket ���� ,��ʾ���ݰ�
		byte[]buf = "�������ݰ�������Ŷ".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.1.100"),8888);
		//3.ʹ���׽��ַ���dp����
		ds.send(dp);
		//4.�ر���Դ
		ds.close();
		System.out.println("send finished...");
	}
	/*
	 * 04.UDP_Receiver :DatagramSocket : UDP Э���·��ͺͽ��� ���ݵ���. 
	 */
	public static void method04() throws IOException{
		//1.���� DatagramSocket ����
		DatagramSocket ds = new DatagramSocket();
		//2.���� DatagramPacket ���� ,��ʾ���ݰ�,��Ž��ܵ�����
		int length = 100;
		byte[]buf = new byte[length];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		String ip = dp.getAddress().getHostAddress();
		//3.��������
		while(true){
			ds.receive(dp);
			if("192.168.1.100".equals(ip)) continue;
		
			//��������
			byte[]data = dp.getData();
			//��ȡ��Ч�ֽ���
			int length2 = dp.getLength();
			//��ȡip��ַ
			System.out.println("["+ip+"]"+new String(data,0,length2));
		}
		
		/*UDP_Receiver02
		 * 		System.out.println("���ն����� , �ȴ����� ..");
//		1. ����  DatagramSocket ����   , ָ���˿� . 
		DatagramSocket ds  = new DatagramSocket(8888);
		
		
//		 * 2. ����  DatagramPacket ����   byte[]  
		int length   = 100; 
		byte[] buf  = new byte[length];
		DatagramPacket dp  = new DatagramPacket( buf,  length) ;
//		 * 
//		 * 3.��������
		System.out.println("===============");
  		ds.receive(dp );  // ���� ,�ȴ�����  
  		System.out.println("===============");
//		 * 		
  		
//		 * 4. �������� 
  		byte[] data = dp.getData();
  		
  		System.out.println(new String(data));
//		 * 5. �ر���Դ  
  		ds.close();
  		
		 */
		
	}
	/*
	 * 05.TCP:Clent   Clent
	 * 
	 */

	public static void method05() throws IOException{
		//1.��ȡ������
		FileInputStream fis = new FileInputStream("�ļ�Ŀ¼");
		//2.����socket ������Է�IP���Է�����Ķ˿ڣ�
		Socket socket = new Socket(InetAddress.getLocalHost(),6666);
		//3.��ȡ��
		OutputStream os = socket.getOutputStream();
		//4.һ�߶�ȡ�����ļ�,һ�߷��͵�������
		byte[]buf = new byte[1024];
		int len;
		while((len =fis.read(buf))!= -1){
			os.write(buf,0,len);
		}
		System.out.println("data send finished..");
		os.close();
		socket.close();
		fis.close();
	}
	/*
	 * 05.TCP:  Server
	 * 
	 */
	public static void method06() throws IOException{
		
		//1.����socket ������Է�IP���Է�����Ķ˿ڣ�
		final ServerSocket ss = new ServerSocket(9899);
		new Thread(){
			public void run(){
				try {
					//2.��������
					Socket accept= ss.accept();
					//3.��ȡ������
					InputStream is = (InputStream) accept.getInputStream();
					FileOutputStream fos = new FileOutputStream("�ļ�Ŀ¼");
					
					//4.һ�߶�ȡ�����ļ�,һ�߷��͵�������
					byte[]buf = new byte[1024];
					int len;
					while((len =is.read(buf))!= -1){
						fos.write(buf,0,len);
					}
					System.out.println("data send finished..");
					fos.close();
					accept.close();
				} catch (Exception e) {
					System.out.println("�����쳣");
				}
			}
		}.start();
		
		
		ss.close();
	}
	
}

