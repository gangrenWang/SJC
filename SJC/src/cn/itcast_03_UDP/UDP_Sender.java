package cn.itcast_03_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * DatagramSocket : UDP Э���·��ͺͽ��� ���ݵ���. 
 * 
 * send(DatagramPacket p) �Ӵ��׽��ַ������ݱ�����
 *  
 *
 * �������� . 
 * 1. ����  DatagramSocket ����  
 * 2. ����  DatagramPacket ����   ,��ʾ���ݰ�
 * 	DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 * 		byte[]  �ֽ�����
 * 		length  buf�ĳ��� 
 * 		InetAddress address : �Է���ip���� 
 * 		port : �Է�����Ķ˿� .
 *  
 * 3. DatagramSocket .send(DatagramPacket ) 
 * 4. �ر���Դ. 
 */
public class UDP_Sender {
	public static void main(String[] args) throws Exception {
		// 1. ���� DatagramSocket ����
		DatagramSocket ds = new DatagramSocket();

		// * 2. ���� DatagramPacket ���� ,��ʾ���ݰ�
		byte[] buf = "���,udp, helloworld !!!".getBytes();

		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.94.84"), 8888);

		// * 3. DatagramSocket .send(DatagramPacket )
		ds.send(dp);
		// * 4. �ر���Դ.
		ds.close();
		System.out.println("�������");

	}
}
