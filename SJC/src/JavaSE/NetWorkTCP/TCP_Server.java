package JavaSE.NetWorkTCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *   TCP 协议  传输 信息(文件).   模拟文件上传 . 
 *    
 *    文件上传的服务端 .   ServerSocket  并不是直接获取流的.  通过accept 接收的方法 ,返回socket ,进而获取流对象. 
 *    
 *     Socket accept() : 接收数据 . 
 *
 */
public class TCP_Server {
	public static void main(String[] args) throws IOException {
		System.out.println("服务器启动,等待数据.."); 
		// 创建 ServerScoket 类
		 ServerSocket ss  = new ServerSocket(6666);
		 
		 // 接收数据
		 Socket accept = ss.accept();
		 
		 //获取流对象 
		 InputStream is  = accept.getInputStream();
		 
		 FileOutputStream fos  = new FileOutputStream("zx.jpg");
		 
		 // 读写数据
		 byte[] b  = new byte[1024] ; 
		 int len; 
		 while (( len  = is.read(b))!=-1 ) {
			fos.write(b, 0, len); 
		}
		 
		 System.out.println("保存完毕");
		 //关闭 
		 fos.close();
		 is.close();
		 accept.close(); 
		 ss.close(); 
		 
	}
}
