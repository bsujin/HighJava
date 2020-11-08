package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B_FileIOtest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하기
		//ouputStream을 만들면 없는 파일은 만들어주고 있는 파일은 덮어쓴다.
		
		try {
			File file = new File("D:/D_Other/out.txt");
			
			//출력용 파일 스트림 객체 생성
			
			//방법1 (객체생성)
			FileOutputStream fout = new FileOutputStream(file);
			
			//방법2 (직접쓰기)
//			FileOutputStream fout = new FileOutputStream("D:/D_Other/out.txt");
			
			for(char ch='A'; ch<='Z'; ch++ ) {
				fout.write(ch);   //출력 스트림을 이용해서 파일에 출력하기 
			}
			System.out.println("출력 작업완료~~~~~");
			
			fout.close();   //스트림 닫기 

			
			System.out.println();
			System.out.println("=======읽어온 파일 내용 =======");
			//저장된 파일 내용을 읽어와 화면에 출력하기 
			FileInputStream fin = new FileInputStream(file);
			
			int c;
			
			//다른 방법 사용 
			while(true) {
				c = fin.read();
				if(c==-1) {
					break;
				}
				
				//println 을 쓰면 문자 하나만 읽고 닫히므로 print사용 
				System.out.print((char)c);
			}
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
		}
	}

}
