package cn.itcast_03_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 *  receive(DatagramPacket p) 从此套接字接收数据报包。 
 *  
 *  
 *  接收数据 . 
 * 1. 创建  DatagramSocket 对象   , 指定端口 . 
 * 		DatagramSocket(8888) 
 * 2. 创建  DatagramPacket 对象   byte[]  
 * 		DatagramPacket(byte[] buf, int length)  
 * 
 * 3.接收数据
 * 		ds.receive(dp ); 
 * 		
 * 4. 解析数据 
 * 
 * 5. 关闭资源  
 */
public class UDP_Receiver {
	public static void main(String[] args) throws Exception {
		System.out.println("接收端启动 , 等待数据 ..");
//		1. 创建  DatagramSocket 对象   , 指定端口 . 
		DatagramSocket ds  = new DatagramSocket(8888);
		
		
//		 * 2. 创建  DatagramPacket 对象   byte[]  
		int length   = 100; 
		byte[] buf  = new byte[length];
		DatagramPacket dp  = new DatagramPacket( buf,  length) ;

		while (true) {
//		 * 3.接收数据
			ds.receive(dp );  // 阻塞 ,等待接收  
			String ip= dp.getAddress().getHostAddress();
			if ("192.168.94.25".equals(ip)  ) {
				continue; 
			}
//		 * 4. 解析数据 
			byte[] data = dp.getData();
			// 获取有效字节数  
			int length2 = dp.getLength();
			
			// 获取 ip 地址. 
			System.out.println("["+ip+"]"+new String(data  , 0  , length2));
			
		}
		
	}
}
