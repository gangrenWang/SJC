package javaSEJQ.com.itheima.www;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * 网络编程: 
 * 三要素: 
 *    IP : 网络中设备的唯一标识
 *    端口: 设备中程序的唯一标识
 *    协议: 网络中数据传输的规则. 
 *    		UDP:面向无连接. 无论是否连接,都会传输数据. 类似 广播 .  数据不安全 ,但是效率高 . 
 *    			视频直播, 电话会议.   
 *    		DatagramSocket   , DatagramPacket 
 *    		TCP:面向连接(三次握手协议 ).确定了连接成功,才能传输数据. 上网  ,文件下载 99.99%
 * 			Socket  / ServerSocket  
 * 
 * 
 *    https:// www.baidu.com:8080
 *    			ip地址:180.149.132.47
 *    
 *    ip地址: 就是网络中设备的唯一标识 192.168.94.84
 *    端口: 程序的唯一标识  范围 0-65535 , 你的指定的端口 1024 - 65535 ,不能 与已被其他程序占用的端口重复. 
 *    
 */
public class NetWorkProgramming {
	public static void main(String[] args) throws UnknownHostException {
	
		InetAddress host = InetAddress.getLocalHost();
		System.out.println(host);
	}

}
