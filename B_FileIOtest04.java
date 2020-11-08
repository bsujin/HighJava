package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_FileIOtest04 {
	
	//콘솔에서 사용자가 입력한 내용을 그대로 파일에 저장하기 
	
	//콘솔 : 컴퓨터 시스템 전체에서 가장 기본적인 입출력 장치를 한데 묶어서 콘솔이라 한다.
	// 가장 기본적인 입력장치 : 키보드 , 출력장치 : 모니터(화면)
	//콘솔에 입력 : 키보드로 입력했다라는 뜻 
	//cmd의 내용을 console에 보여준다 생각하면 됨 
	
	/*
	  System.out 	    - 표준(콘솔) 출력장치  ==> 바이트기반 출력용 스트림
	  System.in 	    - 표준(콘솔)입력장치  ==> 바이트기반 입력용 스트림
	 */
	
	public static void main(String[] args) {

		
		try {
			
			// 바이트 기반의 스트림을 문자기반 스트림으로 변환해주는 스트림 객체 생성
			//콘솔로 입력한 데이터를 가져오기 위한 스트림 객체
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 파일로 저장하는 문자기반 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/test.txt");
			
			System.out.println("아무거나 입력하세요. (입력의 끝은 ctrl + z 키 입니다) >");
			
			
			int c;	//입력받은 값을 담은 변수 (int : 컴퓨터의 코드는 숫자) 
		
			while((c=isr.read()) != -1) {
				fw.write(c);	//콘솔로 입력한 값을 파일로 출력한다.
			}
			
			
			
			isr.close();
			fw.close();
			
			
		} catch (IOException e) {
			
		}
		
		System.out.println("종료되었습니다");
		
	}

}
