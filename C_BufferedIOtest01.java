package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C_BufferedIOtest01 {

	public static void main(String[] args) {
		// 입출력의 성능향상을 위해서 Buffered 스트림을 사용한다.
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 Buffered 스트림 객체 생성
			// 버퍼의 크기를 지정하지 않으면 기본 크기인 8192byte로 버퍼의 크기가 정해진다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			//1~9까지의 문자 출력 
			for(char i='1'; i<='9'; i++) {
				bout.write(i);
			}
			//bout.flush();		//작업을 종료하기전에 버퍼에 남아있는 데이터를 모두 출력 시킨다.
			
			//닫는 순서 
//			fout.close();		//기반이 되는 스트림을 먼저 닫기 
			bout.close();
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
