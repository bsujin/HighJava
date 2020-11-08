package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A_FileTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A_FileTest3 test = new A_FileTest3();
		
		File viewFile = new File("d://d_other"); //보고싶을 디렉토리 설정, ()안에만 바꿔서 가능
				
		test.displayFileList(viewFile);
		
	
	
	}
	
	
	
	// 디렉토리(폴더)를 매개값으로 받아서 해당 디렉토리(폴더)에 있는 모든 파일과 디렉토리(폴더) 목록을 출력하는 메서드
	
	
	//File객체 안에는 디렉토리가 들어와야한다. 
	public void displayFileList(File dir) {
		
		if(!dir.isDirectory()) {
			System.out.println("디렉토리(폴더)만 가능합니다.");
			return;
		}
		System.out.println("[" + dir.getAbsolutePath()+ " ] 디렉토리 내용 ");
		System.out.println();
		
		//전체 목록 가져오기 (File의 배열, String 배열  사용 )
		
		//해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구해온다. 
		
		//1.file 객체 
		File[] files = dir.listFiles();
		
		//2. String  배열 사용
//		String [] filestrs = dir.list();
		
													//년-월-일 오전/오후  시간:분
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복 처리하기
		for(int i=0; i<files.length; i++) {
			String fileName = files[i].getName();	//파일의 이름 저장
			String attr = " ";	//파일의 속성(읽기, 쓰기, 히든, 디렉토리를 구분)
			String size = " "; 	// 파일의 크기
			
			if(files[i].isDirectory()) {
				attr = "<DIR>";
				
			}else {
				size = files[i].length() + " ";
				//읽기 가능하면 R 아니면 공백 
				attr = files[i].canRead() ? "R" : "";
				attr = files[i].canWrite() ? "W" : "";
				attr = files[i].isHidden() ? "H" : "";
				
			}
							//날짜  attr, size, 파일이름
			System.out.printf("%s %5s %12s %s\n", 
					//lastModified :  파일의 마지막 수정날짜 
					df.format(new Date(files[i].lastModified())),	
					attr, size, fileName );
			
			// %s : 문자열(String)로 출력
			//12개의 글자수 : 글자수가 적으면 공백이 출력, 글자수가 많으면 12글자로 잘려서 출력 
			//%n : 줄바꿈 기능
			
		}
		
		//파일 안에 내용을 읽어오고 저장하기 
		
		
		
	}

}
