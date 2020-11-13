package kr.or.ddit.basic;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class B_Sender extends Thread {

//이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당한다.
	
	private Socket socket;
	private DataOutputStream dos;
	private String name;
	private Scanner scan;
	
	
	//소켓만 생성자 만들기
	//클라이언트나 서버에서 만들어지는 소켓을 send로 보내기 
	
	public B_Sender(Socket socket) {
		super();
		this.socket = socket;
		
		
		//스캐너로 입력받아서 변수에 저장하기 
		scan = new Scanner(System.in);
	
		System.out.println("이름 입력 : ");
		name = scan.nextLine();
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	//스레드에서 할 일 : 메시지를 보내기 
	@Override
		public void run() {
			while (dos!=null) {
				
				try {
					//입력을 받아서 outputStrem에 넣어주기 
					dos.writeUTF(name  + " : " + scan.nextLine() );
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		}
	
	
	
	

}
