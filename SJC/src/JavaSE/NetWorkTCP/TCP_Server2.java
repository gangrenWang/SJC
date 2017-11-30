package JavaSE.NetWorkTCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *   TCP Э��  ���� ��Ϣ(�ļ�).   ģ���ļ��ϴ� . 
 *    
 *    �ļ��ϴ��ķ���� .   ServerSocket  ������ֱ�ӻ�ȡ����.  ͨ��accept ���յķ��� ,����socket ,������ȡ������. 
 *    
 *     Socket accept() : �������� . 
 *  
 *  �Ż���  
 *  Apache �����  Commons - FileUpload .
 *  
 *  �����ظ�����: ֻ�ܱ���һ���ļ�.  
 *  ���: �����ֲ��ظ�. 
 *  
 *  ѭ������:  while(true ){  }
 *  
 *  Ч������:  ���߳� ���. 
 *  new Thread(){
 *  
 *  	run(){
 *  		���� Socket 
 *  	}
 *  }.start();
 *  
 */
public class TCP_Server2 {
	public static void main(String[] args) throws IOException {
		System.out.println(System.currentTimeMillis());
		System.out.println("����������,�ȴ�����..");
		// ���� ServerScoket ��
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(8888);

		//while (true) {

			// ��������
			final Socket accept = ss.accept();

			// ���߳�
			new Thread() {
				public void run() {
					try {
						// ���� socket
						// ��ȡ������,��������������������
						InputStream is = accept.getInputStream();
						FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + ".txt");

						// ��д����
						byte[] b = new byte[1024];
						int len;
						while ((len = is.read(b)) != -1) {
							fos.write(b, 0, len);
						}

						System.out.println("�������");
						// �ر�
						fos.close();
					} catch (Exception e) {
						System.out.println("δ֪�쳣");
					}

				}

			}.start();

		}
	//}
}
