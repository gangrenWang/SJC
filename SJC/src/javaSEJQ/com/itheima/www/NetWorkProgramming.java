package javaSEJQ.com.itheima.www;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.InputStream;
/*OSI �ο�ģ�ͣ�����㡢������·�㡢����㡢����㡢�Ự�㡢��ʾ���Ӧ�ò㡣
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
public class NetWorkProgramming {
	public static void main(String[] args) throws IOException {
	
		InetAddress host = InetAddress.getByName("www.baidu.com");
		//System.out.println(host.getHostAddress());
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

}
