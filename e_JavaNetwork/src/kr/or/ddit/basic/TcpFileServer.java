package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 문제) 서버와 클라이언트가 접속이 되면 클라이언트에서 
 * ' d:/D_other/ ' 폴더에 있는 '극한직업.jpg' 파일을
 *  서버쪽에 전송한다.
 *  서버는 클라이언트가 보내온 이미지 데이터를 'd:/D_other/연습용/' 폴더에 '극한직업_전송파일.jpg'로 저장한다. 
 */

//서버는 열어주는것  클라이언트는 접속하는것 (접속하는 쪽이 서버의 주소 (ex.localhost))

//클라이언트가 보내온 파일 데이터를 받아서 'd:/d_other/연습용/극한직업_전송파일.jpg'로 저장한다.

public class TcpFileServer {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
			ServerSocket server = new ServerSocket(7788);
			
			System.out.println("서버가 준비중입니다...");
			
			Socket socket = server.accept();
				
		
			System.out.println("파일을 전송합니다...");

			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			FileOutputStream fout = new FileOutputStream("D:/D_Other/연습용/극한직업.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			
			int data;
			while((data=dis.read())!=-1) {
				bout.write(data);
			}
			
			fout.close();
			dis.close();
			socket.close();
			server.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
		
		
		
		
		
		
		
		
	}

