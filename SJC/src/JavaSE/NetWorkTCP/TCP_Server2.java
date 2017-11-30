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
 *  优化版  
 *  Apache 的组件  Commons - FileUpload .
 *  
 *  名字重复问题: 只能保留一个文件.  
 *  解决: 让名字不重复. 
 *  
 *  循环问题:  while(true ){  }
 *  
 *  效率问题:  多线程 解决. 
 *  new Thread(){
 *  
 *  	run(){
 *  		处理 Socket 
 *  	}
 *  }.start();
 *  
 */
public class TCP_Server2 {
	public static void main(String[] args) throws IOException {
		System.out.println(System.currentTimeMillis());
		System.out.println("服务器启动,等待数据..");
		// 创建 ServerScoket 类
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(8888);

		//while (true) {

			// 接收数据
			final Socket accept = ss.accept();

			// 多线程
			new Thread() {
				public void run() {
					try {
						// 处理 socket
						// 获取流对象,创建输出流对象，输出数据
						InputStream is = accept.getInputStream();
						FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + ".txt");

						// 读写数据
						byte[] b = new byte[1024];
						int len;
						while ((len = is.read(b)) != -1) {
							fos.write(b, 0, len);
						}

						System.out.println("保存完毕");
						// 关闭
						fos.close();
					} catch (Exception e) {
						System.out.println("未知异常");
					}

				}

			}.start();

		}
	//}
}
