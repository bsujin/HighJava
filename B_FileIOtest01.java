package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class B_FileIOtest01 {

	public static void main(String[] args) {
		
		//FileInputStream 객체를 이용한 파일 내용 읽기 
		//한글을 가져오면 깨질수 있음 (3byte이므로) => byte기반으로 출력한것이므로
		
		//화면에만 출력, 읽어오는 역할만 하는것  -> inputStream만 사용 
		
		try {
			//읽어올 파일을 매개값으로 받는 FileInputStream객체 생성하기
						
			//방법 1  
//			FileInputStream fin = new FileInputStream("D:/D_Other/test.txt");
			
			//방법 2 
			File file = new File("D:/D_OTHER/test.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c;  // 읽어온 데이터가 저장될 변수
			
			while ((c=fin.read()) != -1) {
				//읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
				
			}
			
			fin.close();    //스트림 닫기 				
			
		} catch (IOException e) {
		
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
			//printStackTrace는 가장 자세한 예외 정보를 제공한다.
		}
	}

}
