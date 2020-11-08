package kr.or.ddit.basic;

import java.io.File;

public class A_FileTest02 {

	public static void main(String[] args) {
	
		File f1 = new File("D:/D_Other/test.txt");
		
		//파일 크기 : length 
		System.out.println(f1.getName() + " 의 크기는 : " + f1.length() + "bytes");
		System.out.println();
		
		//파일 전체 경로 : path
		System.out.println("Path : " + f1.getPath());
		System.out.println("AbsolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		//.은 현재폴더 , .. 부모폴더 
		File f2 = new File(".");
		System.out.println("Path : " + f2.getPath());
		System.out.println("AbsolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
		
		//f1가 파일인지, 디렉토리인지 확인
		if(f1.isFile()) {
			System.out.println(f1.getName() + " 은 파일입니다. ");
		}else if(f1.isDirectory()) {
			System.out.println(f1.getName() + " 은 디렉토리(폴더)입니다. ");
		}else {				//실제로 존재하지 않으면 else로 옴 

			System.out.println(f1.getName() + " 은 뭘까???");
		}
		System.out.println();
		
		
		// f2가 파일인지, 디렉토리인지 확인 
		if(f2.isFile()) {
			System.out.println(f2.getName() + " 은 파일입니다. ");
		}else if(f2.isDirectory()) {
			System.out.println(f2.getName() + " 은 디렉토리(폴더)입니다. ");
		}else {				//실제로 존재하지 않으면 else로 옴 

			System.out.println(f2.getName() + " 은 뭘까???");
		}
		System.out.println();
		
		
		//현재 존재하지 않는 파일을 지정했을 때 
		File f3 = new File("D:/D_Other/sample.exe");
		if(f3.isFile()) {
			System.out.println(f3.getName() + "은 파일입니다.");
		}else if(f3.isDirectory()) {
			System.out.println(f3.getName() + " 은 디렉토리(폴더)입니다. ");
		}else {				
			System.out.println(f3.getName() + " 은 뭘까???");
		}
		
		
	}

}
