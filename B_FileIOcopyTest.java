package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B_FileIOcopyTest {
	
	//'d:/D_Other/' 폴더에 있는 '극한직업.jpg' 파일을 
	// 'd:/D_Other/연습용' 폴더에 '극한직업_복사본.jpg'이름으로 복사하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			File file = new File("D:/D_Other/극한직업.jpg");
			
			FileInputStream fin = new FileInputStream(file);
			
			FileOutputStream fcopy = new FileOutputStream("d:/d_other/연습용/극한직업_복사본.jpg");
			
			int data;
			
			while((data=fin.read()) != -1) {
				fcopy.write(data);
			}
			
			fin.close();
			fcopy.close();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("오류");
		}
		
		System.out.println("복사완료!!!!");
		
		
		//===========================================================================//
		
		
		//선생님 풀이
		
		String fileName = "극한직업.jpg";
		File file = new File("d:/D_Other/" + fileName);
		
		if(!file.exists()) {	//파일의존재유무
			System.out.println(file.getPath() + "파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다.");
			return;
		}
		
		try {
			
			//복사할 파일 스트림 객체 생성(원본 파일용)
//			FileInputStream fin = new FileInputStream(file);
			
			//복사될 파일 스트림 객체 생성(저장될 파일용)
//			FileOutputStream fout = new FileOutputStream("d:/D_Other/연습용/극한직업_복사본.jpg");
		
			
			//buffered 사용
			FileInputStream bin = new FileInputStream(file);
			FileOutputStream fout = new FileOutputStream("d:/D_Other/bufferTest.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			
			System.out.println("복사 시작...");
			
			int data;	//읽어온 데이터를 저장할 변수
			
			/*
			 * while((data = fin.read()) != -1){
				fout.write(data);	//데이터를 저장
			}
			
			fout.flush();
			
			// 사용했던 스트림 닫기 
			fout.close();
			fin.close();
			*/
			
			
			while((data = bin.read()) != -1) {
				bout.write(data);
			}
			bout.flush();
			bout.close();
			bin.close();
			
			
			System.out.println("복사 완료...");
			
			} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}

