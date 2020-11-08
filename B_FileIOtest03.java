package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class B_FileIOtest03 {

	public static void main(String[] args) {
		// 문자 기반의 스트림을 사용하여 파일 내용 읽어오기
		//문자단위로 데이터를 읽어오는 것  (byte일 경우 한글이 깨지는 현상-> 문자기반스트림으로 변경하여 출력)
		
		try {
			
			//문자기반의 파일 입력용 스트림 객체 생성
			FileReader fr = new FileReader("D:/D_Other/test.txt");
			
			int c;
			
			while ((c=fr.read()) != -1) {
				System.out.print((char)c);

			}
			
			fr.close();
			
		}catch (IOException e) {
			// TODO: handle exception
		}

	}

}
