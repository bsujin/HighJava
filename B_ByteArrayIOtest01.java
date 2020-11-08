package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class B_ByteArrayIOtest01 {
	
	//input - output 출력 형태의 과정 ***

	public static void main(String[] args) {
		
		// byte배열의 데이터를 입력 스트림으로 읽어서 출력 스트림으로 출력하는 예제

		byte[ ] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[ ] outSrc = null;
		
		//입력용 스트림 객체 생성 
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		//출력용 스트림 객체 생성
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data; 	//읽어온 자료가 저장될 변수
		
		//()안을 먼저 읽어와 처리한 뒤 더이상 읽어올 것이 있나없나 검사 (-1) 
		// read() 메서드 ==> 더이상 읽어올  자료가 없으면 -1을 반환 
		
		
		//하나씩 데이터를 읽어오는 반복문
		while ((data = input.read()) != -1 ) {
			
			//읽어온 데이터를 사용하여 처리하는 내용을 기술한다.
			
			output.write(data);	//출력용 스트림을 이용하여 읽어온 데이터를 출력한다.(용도에 따라서 사용)
		}
	
		
		//출력된 스트림 값을 꺼내서 배열로 변환하기
		outSrc = output.toByteArray();
		
		// close를 사용하려면 try-catch 하거나,trows 해줘야함
		
		try {
			//사용했던 자원(스트림 객체)을 반납한다.
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("inSrc ==> " + Arrays.toString(inSrc));
		System.out.println("outSrc ==> " + Arrays.toString(outSrc));
		
		
		
		
	}

}
