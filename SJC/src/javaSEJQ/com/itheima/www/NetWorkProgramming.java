package javaSEJQ.com.itheima.www;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
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
	public static void main(String[] args) throws UnknownHostException {
	
		InetAddress host = InetAddress.getLocalHost();
		System.out.println(host);
	}

}
