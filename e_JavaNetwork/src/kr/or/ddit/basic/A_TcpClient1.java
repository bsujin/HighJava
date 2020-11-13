package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class A_TcpClient1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//현재 자신의 컴퓨터를 나타내는 방법
		
		//1. 원래의 IP주소 : 예 ) 192.168.42.2 /  192.168.42.22
		//2. 지정된 IP주소 : 127.0.0.1 (localHOST) -> 모든 컴퓨터에서 이렇게 사용하면 자기자신의 컴퓨터 
		//3. 원래의 컴퓨터 이름 : 예)sem
		//4. 지정된 컴퓨터 이름 : localHost -> 자기자신의 컴퓨터로 알고있음
	
		
		
		
		
		//서버의 ip가 저장될 변수 
		String serverIp = "localHost";
		System.out.println(serverIp + " 서버에 연결 중 입니다... ");
		
		//소켓 객체 만들기 
		//서버의 IP주소와 Port 번호를 지정하여 Socket객체를 생성한다.
		//Socket객체는 생성이 완료되면 해당 서버로 요청신호를 자동으로 보낸다.
		
		Socket socket = new Socket(serverIp, 7777);
		//소켓이 정상적으로 만들어지면 내부에서 요청신호를 보냄 
		
		
		// 이 부분은 서버와 연결이 완료된 이후의 처리 내용을 기술하면 된다.
		System.out.println("서버에 연결되었습니다.");
		System.out.println();
		
		
		//서버에서 보내온 메시지를 받아서 화면에 출력하기
		//클라이언트는 받는것- Socket의 InputStream 객체 생성
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// 서버가 보낸 자료를 읽어와서 출력한다.
		System.out.println("서버가 보낸 메시지 : " + dis.readUTF());
		System.out.println();
		
		System.out.println("연결을 종료합니다...");
		
		//스트림과 소켓 닫기 
		dis.close();
		socket.close();
		
		
		//실행은 윈도우 탐색기 - 두개의 창을 열고 확인해보기 
		//하나는 java kr.or.ddit.basic.A_TcpServer1
		//하나는 java kr.or.ddit.basic.A_TcpClient1
		
	}

}
