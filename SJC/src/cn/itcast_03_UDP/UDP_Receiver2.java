package cn.itcast_03_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 *  receive(DatagramPacket p) �Ӵ��׽��ֽ������ݱ����� 
 *  
 *  
 *  �������� . 
 * 1. ����  DatagramSocket ����   , ָ���˿� . 
 * 		DatagramSocket(8888) 
 * 2. ����  DatagramPacket ����   byte[]  
 * 		DatagramPacket(byte[] buf, int length)  
 * 
 * 3.��������
 * 		ds.receive(dp ); 
 * 		
 * 4. �������� 
 * 
 * 5. �ر���Դ  
 */
public class UDP_Receiver2 {
	public static void main(String[] args) throws Exception {
		System.out.println("���ն����� , �ȴ����� ..");
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
  		
  		
  		
	}
}
