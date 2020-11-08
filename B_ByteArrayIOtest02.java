package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class B_ByteArrayIOtest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[ ] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[ ] outSrc = null;
		
		
		byte [ ] temp = new byte[4];	//4개짜리 배열 생성
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		//사용하기위해서는 try-catch , IOexception으로 사용
		
		try {
			//읽어올 데이터가 있는지 확인 
			while(input.available() > 0) {

				
//그냥 읽어온것 (int read(byte[] b) 사용
				
//				input.read(temp);	//바이트배열의 크기만큼 읽어온다.
//				
//				// temp 배열의 데이터를 출력 스트림으로 출력한다.
//				output.write(temp);
				
				
				
//int read(byte[]b, int off, int len) 으로 변경하기 
				
				//반환값을 저장해야한다
				//반환값 : 실제 읽어온 데이터의 byte수를 반환한다.
				int len = input.read(temp); 
				
				//읽어온 데이터가 저장된 temp배열에서 반환값만큼 0번째부터 읽어온 개수(반환값)만큼 출력한다.
				output.write(temp, 0, len);
				
				
				System.out.println("반복문 안에서 temp ==> " + Arrays.toString(temp));
			}
			
			//배열로 바꿔주기
			outSrc = output.toByteArray();
			
			System.out.println();
			System.out.println(" inSrc ==> " + Arrays.toString(inSrc));
			System.out.println(" outSrc ==> " + Arrays.toString(outSrc));
			
		} catch (IOException e) {
			// TODO: handle exception
		}
				
		/*
		 * 출력하였을 때 12개가 된 이유 : 배열로 읽어오면, 배열의 개수만큼 읽어온다.
		 * temp 배열이 4개 , 마지막에 2개가 남았는데 남은 부분은 그전에 있는 값을 가져온다.
		 * ==> 바이트 배열을 사용할 때에는 원본과 출력본이 같도록 주의해야한다.
		 * ==> 해결방법 : 배열에 저장하고 그값을 그대로 출력한것 (현재) - int read(byte[] b) 사용 - 반환값 : 실제 읽어온 갯수
		 *  -> int read(byte[]b, int off, int len) 으로 변경하기
		 *  
		 *   len을 사용할 경우 len의 값을 저장할 변수 필요 
		 */
		
		
	}

}
