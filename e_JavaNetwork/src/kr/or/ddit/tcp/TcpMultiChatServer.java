package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {

	// 접속한 클라이언트의 정보를 저장할 Map객체 변수 선언
	// ==> key값 : 접속한 사람의 이름 / value값 : 접속한 클라이언트와 접속된 Socket객체

	private Map<String, Socket> clientMap;

	// 생성자
	public TcpMultiChatServer() {

		// clientMap을 동기화 처리가 되도록 생성한다.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}

	public static void main(String[] args) {

		new TcpMultiChatServer().serverStart();

	}

	// 서버 시작 메서드
	private void serverStart() {
		ServerSocket server = null;
		Socket socket = null;

		try {

			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = server.accept(); // 클라이언트의 접속을 기다림 (한개만 있으면 하나만 접속, 여러개일 경우 반복문 사용 )

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + " ]에서 접속했습니다. ");

				// 서버용 쓰레드 시작하기
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (server != null) try { server.close();	} catch (Exception e) {		}
		}

	}

	// clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {

		// clientMap의 데이터 개수만큼 반복
		for (String name : clientMap.keySet()) {

			try {

				DataOutputStream dos = new DataOutputStream(

						// 클라이언트와 연결된 소켓의 OutputStream객체 구하기
					clientMap.get(name).getOutputStream());

				dos.writeUTF(msg);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	// 클라이언트와 연결된 소켓을 이용하여 하나의 클라이언트가 보내온 메시지를 다른 클라이언트들에게 전송하는 Thread를 inner Class형태로 만든다.
	class ServerThread extends Thread{
		
		private Socket socket;	//접속한 소켓 
		private DataInputStream dis;
		private DataOutputStream dos;
				
		//생성자				접속한 소켓 		
		public ServerThread(Socket socket) {
			this.socket = socket;
			
			try {
				//수신용
				dis = new DataInputStream(socket.getInputStream());
				
				//송신용
				dos = new DataOutputStream(socket.getOutputStream());
				
			} catch (Exception e) {
				
				
			}
		}	
		
		//실제 일이 처리되는 곳 :
		//서버가 맨처음 자기 이름을 입력, 접속을 하면 서버쪽으로 보내줌 -> 서버는 그 이름을 받아서 그 이름이 접속한 클라이언트를 저장함 
		//Map은 같은 이름이면, 나중에 값이 덮어짐으로 무조건 그사람의 이름으로 인식을 하도록 하여 이름이 있으면 중복된다는 메시지, 없으면 사용가능- 등록

		@Override
		public void run() {
			
			String name = " "; 	//클라이언트가 보낸 이름을 저장할 변수 선언
			
			try {

				// 접속이 성공하면, 이름을 먼저 서버쪽으로 보냄 (이름이 없으면 ok, 중복되면 메시지)
				// ==> 클라이언트가 보낸 첫번째 데이터는 사용자의 이름, 
				//이 이름이 중복되는지 여부를 feedback으로 클라이언트에게 보내주고  이름이 중복되지 않으면 반복문을 탈출한다.
				
				while (true) {
					name = dis.readUTF(); //첫번째 데이터 읽기(이름 데이터)
					
					if(clientMap.containsKey(name)) {	//이름이 중복될 때 
						dos.writeUTF("이름 중복");       //'이름중복'메시지 전송
					}else {	//이름이 중복되지 않을 때 
						
						dos.writeUTF("OK");	 			//중복되지 않으면, 'OK'메시지 전송 후 반복문 나가기  
						break;						
					}
				}	//while문 끝 (이름은 정상적으로 들어옴)
				
				// 대화명을 받아서 전체 클라이언트에게 대화방 참여 메시지를 보낸다.
				//전체 메시지 메서드 -sendToAll
				sendToAll("[ " + name + " ] 님이 대화방에 입장했습니다.");
				
				// 대화명과 클라이언트의 Socket객체를 Map에 저장한다.
				clientMap.put(name, socket);
				
				System.out.println("현제 서버 접속자 수 : " + clientMap.size() + "명");
				
				// 하나의 클라이언트가 보낸 메시지를 받아서 전체 클라이언트들에게 보낸다.
				while(dis!=null) {
					sendToAll(dis.readUTF());
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				//이 finally영역이 실행된다는 것은 클라이언트가 접속을 종료했다는 의미 
				sendToAll(" [ " + name + " ] 님이 접속을 종료했습니다.");			
		
				//접속을 종료한 클라이언트를 Map에서 삭제한다.
				clientMap.remove(name);
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + " ]에서 접속을 종료했습니다. ");
				
				System.out.println("현제 서버 접속자 수 : " + clientMap.size() + "명");
				
			}
			
		}
		
	}
	
	
	
	
}
