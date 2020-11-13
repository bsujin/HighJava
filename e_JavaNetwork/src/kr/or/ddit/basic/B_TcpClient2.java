package kr.or.ddit.basic;

import java.net.Socket;

public class B_TcpClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Socket socket = new Socket("localhost", 7788);
			System.out.println("서버에 연결되었습니다.");
			
			B_Sender sender = new B_Sender(socket);
			B_Receiver receiver = new B_Receiver(socket);
		
			sender.start();
			receiver.start();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
