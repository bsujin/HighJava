package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트가 전송 
public class TcpFileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			
			System.out.println("서버가 준비중입니다...");

			Socket socket = new Socket("localhost",7788);
			
			
			FileInputStream fin = new FileInputStream("D:/D_Other/극한직업.jpg");
			BufferedInputStream copy = new BufferedInputStream(fin);	//버퍼로 더 빠르게 읽어오기 
			
			OutputStream out = socket.getOutputStream();	//소켓에서 읽어오기
			DataOutputStream dout = new DataOutputStream(out);
			
			
			int data;
			while((data = copy.read())!= -1) {
				dout.write(data);
			}
		
			fin.close();
			dout.close();
			
			System.out.println("복사 완료!!!");
			
		} catch (Exception e) {
			System.out.println("복사 오류 !!");
		
		} 
	}

}
