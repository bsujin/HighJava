package kr.or.ddit.basic;

import java.io.File;

public class A_FileTest01 {

	public static void main(String[] args) {
		// File 객체 만들기 연습

		/*
		 * 표기법만 다른것 -> 전체를 한꺼번에 둘건지, 분할에서 줄건지 -> 분할에서 줄 때 파일 객체에 담아서 줄지, 문자열로 줄지의 차이
		 */

		/*
		 * 1. new File (String 파일 또는 경로); ===> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일 명 사이의 구분 문자는
		 * 역슬레시('\')를 사용하거나 슬레쉬('/')를 사용할 수 있다.
		 */

		// 대소문자 상관이 없으나 대소문자 구분해주는것이 좋다.
		// file 객체 만들기 - 파일의 경로
		// File file1 = new File("D:/D_Other/test.txt"); : 구분 문자로 '/' 사용한 경우
		File file1 = new File("D:\\D_Other\\test.txt"); // : 구분 문자로 '\\' 사용한 경우

		System.out.println(" 파일 명 : " + file1.getName());
		System.out.println("디렉토리인지 검사 ");
		System.out.println(" 디렉토리 일까 ? " + file1.isDirectory());
		System.out.println(" 파일 일까 ? " + file1.isFile());
		System.out.println();

		// new File (파일이 들어있는 경로 까지만 작성)
		// file객체를 만들때 ( ) 속에 주어진 것이 파일 또는 디렉토리가 될 수 있다.

		File file2 = new File("d:/d_other");

		System.out.println(" 파일 명 : " + file2.getName());
		System.out.println("디렉토리인지 검사 ");
		System.out.println(" 디렉토리 일까 ? " + file2.isDirectory());
		System.out.println(" 파일 일까 ? " + file2.isFile());
		System.out.println();

		/*
		 * (앞에가 폴더, 뒤에가 파일 이름) 2. new File(File parent, String child) ==> 'parent'디렉토리
		 * 안에 있는 'child'파일을 나타낸다.
		 */

		// file2 - 디렉토리를 갖는 파일 객체를 넣어줌 = d:/d_other
		File file3 = new File(file2, "test.txt");
		System.out.println(" 파일 명 : " + file3.getName());
		System.out.println("디렉토리인지 검사 ");
		System.out.println(" 디렉토리 일까 ? " + file3.isDirectory());
		System.out.println(" 파일 일까 ? " + file3.isFile());
		System.out.println();

		/*
		 * 3. new File(String parent, String child) ==> 'parent'디렉토리 안에 있는 'child' 파일을
		 * 나타낸다
		 */
		File file4 = new File("d:/D_other", "test.txt");
		System.out.println(" 파일 명 : " + file4.getName());
		System.out.println("디렉토리인지 검사 ");
		System.out.println(" 디렉토리 일까 ? " + file4.isDirectory());
		System.out.println(" 파일 일까 ? " + file4.isFile());
		System.out.println();

		System.out.println("==========================================");

		// 디렉토리(폴더) 만들기
		/*
		 * 
		 * - mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 생성한다. ==> 반환 값 : 만들기 성공(true), 만들기
		 * 실패(false) ==> 중간 부분의 경로가 모두 만들어져 있어야 마지막 위치의 폴더를 만들 수 있다.
		 * 
		 * - mkdirs() ==> 중간 부분의 경로가 없으면 중간 부분의 경로도 같이 만들어준다.
		 */

		File file5 = new File("D:/D_Other/연습용");
		System.out.println(" 파일 명 : " + file5.getName());
		System.out.println("디렉토리인지 검사 ");
		System.out.println(" 디렉토리 일까 ? " + file5.isDirectory());
		System.out.println(" 파일 일까 ? " + file5.isFile());
		System.out.println();

		// 존재하지 않아 둘다 FALSE의 결과가 나온다

		// 존재여부를 확인하는것 : exists
		System.out.println(file5.getName() + " 의 존재 여부 : " + file5.exists());

		System.out.println();
		System.out.println("디렉토리를 만드는중...");

		// 디렉토리 만드는 방법
		// 2번 실행하면 디렉토리(폴더)가 만들어져서 실패로 바뀜
		if (file5.mkdir()) {
			System.out.println(file5.getName() + "디렉토리 만들기 성공~~~");
		} else {
			System.out.println(file5.getName() + "디렉토리 만들기 실패!!!");
		}

		System.out.println();

		// 디렉토리 만드는 방법 2
		// mkdir은 폴더를 만들어주는데, 바로 앞(java)폴더에 만들어주는데 현재 java폴더,text폴더도 없음
		// 무조건 폴더를 만들어 주는것이 아님 -> mkdirs를 사용하면 다 만들어준다.

		File file6 = new File("D:/D_other/test/java/src");
		if (file6.mkdirs()) {
			System.out.println(file6.getName() + "디렉토리 만들기 성공~~~");
		} else {
			System.out.println(file6.getName() + "디렉토리 만들기 실패!!!");
		}
		System.out.println();

	}

}
