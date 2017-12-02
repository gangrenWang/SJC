package JavaSE.NetWorkTCP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



/*
 *   文件上传的客户端 .  
 *   OutputStream getOutputStream()  获取输出流 , 把数据写出到服务器。 
 *   InputStream  getInputStream()  获取输入流解析服务器响应的数据.。 
 *   
 */
public class TCP_Client {
	public static void main(String[] args) throws Exception {
		System.out.println("客户端启动... ");
		// 获取流对象
		FileInputStream fis = new FileInputStream("data.txt");
		// 创建 Scoket ( 对方 ip, 对方程序的端口 )
		Socket socket = new Socket(InetAddress.getLocalHost(), 5556);
		// 获取流
		OutputStream os = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		// 读写数据
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		
		socket.shutdownOutput();
		while(true){
		System.out.println("数据发送完毕");
		byte[]buf = new byte[1024];
		len = in.read(buf);
		String str = new String(buf,0,len);
		
		System.out.println(str);
		if(str!=null){
			socket.close();
			os.close();
			fis.close();
			break;
		}
		}
		
		
		
	}
}
