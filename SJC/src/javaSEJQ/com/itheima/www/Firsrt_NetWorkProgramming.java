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
 *OSI 参考模型：物理层、数据链路层、网络层、传输层、会话层、表示层和应用层。
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
public class Firsrt_NetWorkProgramming {
	public static void main(String[] args) throws IOException {
	
		
		

}
	/*
	 * 01.InetAddress 。 IP地址对象
	 */
	public static void method01() throws IOException{
		InetAddress host = InetAddress.getByName("www.baidu.com");
		//System.out.println(host.getHostAddress());
	}
	
	/*
	 * 02.URL 统一资源定位符。利用URL获取对应资源。
	 */
	public static void method02() throws IOException{
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
	/*
	 * 03.UDP_send :DatagramSocket : UDP 协议下发送和接收 数据的类. 
	 */
	public static void method03() throws IOException{
		//1.创建 DatagramSocket 对象
		DatagramSocket ds = new DatagramSocket();
		//2.创建 DatagramPacket 对象 ,表示数据包
		byte[]buf = "我是数据包的内容哦".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.1.100"),8888);
		//3.使用套接字发送dp对象
		ds.send(dp);
		//4.关闭资源
		ds.close();
		System.out.println("send finished...");
	}
	/*
	 * 04.UDP_Receiver :DatagramSocket : UDP 协议下发送和接收 数据的类. 
	 */
	public static void method04() throws IOException{
		//1.创建 DatagramSocket 对象
		DatagramSocket ds = new DatagramSocket();
		//2.创建 DatagramPacket 对象 ,表示数据包,存放接受的数据
		int length = 100;
		byte[]buf = new byte[length];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		String ip = dp.getAddress().getHostAddress();
		//3.接收数据
		while(true){
			ds.receive(dp);
			if("192.168.1.100".equals(ip)) continue;
		
			//解析数据
			byte[]data = dp.getData();
			//获取有效字节数
			int length2 = dp.getLength();
			//获取ip地址
			System.out.println("["+ip+"]"+new String(data,0,length2));
		}
		
		/*UDP_Receiver02
		 * 		System.out.println("接收端启动 , 等待数据 ..");
//		1. 创建  DatagramSocket 对象   , 指定端口 . 
		DatagramSocket ds  = new DatagramSocket(8888);
		
		
//		 * 2. 创建  DatagramPacket 对象   byte[]  
		int length   = 100; 
		byte[] buf  = new byte[length];
		DatagramPacket dp  = new DatagramPacket( buf,  length) ;
//		 * 
//		 * 3.接收数据
		System.out.println("===============");
  		ds.receive(dp );  // 阻塞 ,等待接收  
  		System.out.println("===============");
//		 * 		
  		
//		 * 4. 解析数据 
  		byte[] data = dp.getData();
  		
  		System.out.println(new String(data));
//		 * 5. 关闭资源  
  		ds.close();
  		
		 */
		
	}
	/*
	 * 05.TCP:Clent   Clent
	 * 
	 */

	public static void method05() throws IOException{
		//1.获取流对象
		FileInputStream fis = new FileInputStream("文件目录");
		//2.创建socket （传入对方IP，对方程序的端口）
		Socket socket = new Socket(InetAddress.getLocalHost(),6666);
		//3.获取流
		OutputStream os = socket.getOutputStream();
		//4.一边读取本地文件,一边发送到服务器
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
		
		//1.创建socket （传入对方IP，对方程序的端口）
		final ServerSocket ss = new ServerSocket(9899);
		new Thread(){
			public void run(){
				try {
					//2.接收数据
					Socket accept= ss.accept();
					//3.获取流对象
					InputStream is = (InputStream) accept.getInputStream();
					FileOutputStream fos = new FileOutputStream("文件目录");
					
					//4.一边读取本地文件,一边发送到服务器
					byte[]buf = new byte[1024];
					int len;
					while((len =is.read(buf))!= -1){
						fos.write(buf,0,len);
					}
					System.out.println("data send finished..");
					fos.close();
					accept.close();
				} catch (Exception e) {
					System.out.println("出现异常");
				}
			}
		}.start();
		
		
		ss.close();
	}
	
}

