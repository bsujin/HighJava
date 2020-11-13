package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.net.Socket;

// 이 클래스는 소켓에서 메시지를 받아서 화면서 출력하는 역할을 담당한다.

public class B_Receiver extends Thread{

	private Socket socket;
	//데이터를 받을것 : inputStream
	private DataInputStream dis;
	
	//생성자 
	
	public B_Receiver(Socket socket) {
		super();
		this.socket = socket;



	try {
		dis = new DataInputStream(socket.getInputStream());
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	
	
	
	//스레드에서 할일 : 데이터를 받아서 출력
	@Override
	public void run() {
		
		while(dis!=null) {
		
			try {
				//출력
			System.out.println(dis.readUTF());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	
	
}
