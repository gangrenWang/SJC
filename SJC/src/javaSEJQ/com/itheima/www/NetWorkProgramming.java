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
/*OSI 参考模型：物理层、数据链路层、网络层、传输层、会话层、表示层和应用层。
 * 
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
	public static void main(String[] args) throws IOException {
	
		InetAddress host = InetAddress.getByName("www.baidu.com");
		//System.out.println(host.getHostAddress());
		//URL 统一资源定位符
		URL url = new URL("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1062523921,2025672967&fm=173&s=671CEB2A0AB061A5323D32D3030090A0&w=313&h=379&img.JPG");
		String file = url.getFile();
		System.out.println(file);
		//获取URL所属主机
		String tempHost = url.getHost();
		System.out.println(tempHost);
		int port = url.getPort();
		System.out.println(port);
		//获取路径
		String path = url.getPath();
		System.out.println(path);
		//获取协议
		String protocol = url.getProtocol();
		System.out.println(protocol);
		
		//使用URLconnection将URL资源下载到本地
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
