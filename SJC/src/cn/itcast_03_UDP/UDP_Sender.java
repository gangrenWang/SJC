package cn.itcast_03_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * DatagramSocket : UDP 协议下发送和接收 数据的类. 
 * 
 * send(DatagramPacket p) 从此套接字发送数据报包。
 *  
 *
 * 发送数据 . 
 * 1. 创建  DatagramSocket 对象  
 * 2. 创建  DatagramPacket 对象   ,表示数据包
 * 	DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 * 		byte[]  字节数据
 * 		length  buf的长度 
 * 		InetAddress address : 对方的ip对象 
 * 		port : 对方程序的端口 .
 *  
 * 3. DatagramSocket .send(DatagramPacket ) 
 * 4. 关闭资源. 
 */
public class UDP_Sender {
	public static void main(String[] args) throws Exception {
		// 1. 创建 DatagramSocket 对象
		DatagramSocket ds = new DatagramSocket();

		// * 2. 创建 DatagramPacket 对象 ,表示数据包
		byte[] buf = "你好,udp, helloworld !!!".getBytes();

		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.94.84"), 8888);

		// * 3. DatagramSocket .send(DatagramPacket )
		ds.send(dp);
		// * 4. 关闭资源.
		ds.close();
		System.out.println("发送完毕");

	}
}
