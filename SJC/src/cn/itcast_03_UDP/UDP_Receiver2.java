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
public class UDP_Receiver2 {
	public static void main(String[] args) throws Exception {
		System.out.println("接收端启动 , 等待数据 ..");
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
  		
  		
  		
	}
}
