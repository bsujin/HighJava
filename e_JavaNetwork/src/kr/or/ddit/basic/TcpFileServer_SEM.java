package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 문제) 서버와 클라이언트가 접속이 되면 클라이언트에서 
 * ' d:/D_other/ ' 폴더에 있는 '극한직업.jpg' 파일을
 *  서버쪽에 전송한다.
 *  서버는 클라이언트가 보내온 이미지 데이터를 'd:/D_other/연습용/' 폴더에 '극한직업_전송파일.jpg'로 저장한다. 
 */



//클라이언트가 보내온 파일 데이터를 받아서 'd:/d_other/연습용/극한직업_전송파일.jpg'로 저장한다.

public class TcpFileServer_SEM {
	
	private ServerSocket server;
	private Socket socket;
	
	//파일을 읽어올 때 사용 
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	
	private void serverStart() {
		File saveDir = new File("D:/D_Other/연습용");	//저장할 폴더
		
		if(!saveDir.exists()) {	//저장할 폴더가 없으면 새로 생성한다.
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7878);
			System.out.println("서버가 준비되었습니다.");
			
			socket = server.accept();	//클라이언트의 요청을 기다린다.
			
			System.out.println("파일 전송 시작....");
	
			File saveFile = new File(saveDir, "극한직업_전송파일.jpg");
			
			//소켓에서 데이터를 입력받을 스트림 객체 생성 
			bis = new BufferedInputStream(socket.getInputStream());
			
			//파일에 저장할 스트림 객체를 생성 
			bos = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			//소켓응로 읽어온 데이터를 파일로 출력한다.
			while((length = bis.read(temp))>0) {
//				bos.write(temp);	//그냥 출력하면 문제가 생김 (byteArray 참고)
				bos.write(temp, 0, length);	//그냥 출력하면 문제가 생김 
			}
			
			bos.flush();	//
			System.out.println("파일 다운로드 완료...");
			
			
		} catch (Exception e) {
			
			System.out.println("다운로드 실패!!!");
			
		} finally {
			if(bis != null) try { bis.close(); } catch (IOException e) { }
			if(bos != null) try { bos.close(); } catch (IOException e) { }
			if(socket != null) try { socket.close(); } catch (IOException e) { }
			if(server != null) try { server.close(); } catch (IOException e) { }
				
			}
		}


	public static void main(String[] args) {
		new TcpFileServer_SEM().serverStart();
		
	}
		
		
		
		
		
		
		
		
	}

