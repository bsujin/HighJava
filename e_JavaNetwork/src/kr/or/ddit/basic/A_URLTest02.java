package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class A_URLTest02 {

	public static void main(String[] args) throws IOException {
		// URLConnection ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스

		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제

		// try-cath 또는 throws 사용
		URL url = new URL("https://www.naver.com");

		// URL Connection 객체 구하기
		URLConnection urlCon = url.openConnection();

		// Header 정보 가져오기(서버나 클라이언트에서 정보를 가져올 때, 미리 설정해놓은 값 - map에 저장)
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();

		// headerMap의 key값과 value값 출력하기
		for (String headerKey : headerMap.keySet()) {
			System.out.println(headerKey + " : " + headerMap.get(headerKey));

		}
		System.out.println("-----------------------------------------------");

		// 해당 문서의 내용을 가져오기
		/*
		 * 방법 1 ==> URLConnection 객체를 이용하는 방법
		 * 
		 * 서버에 있는 파일의 내용을 가져오기 위한 입력용 스트림 객체 생성
		 * 
		 */

//		// 위에서 가져온 URL의 정보를 가져와서 저장
//		InputStream is = urlCon.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//
//		// 속도를 위해 BUFFER사용
//		BufferedReader br = new BufferedReader(isr);
//
//		// 자료를 읽어와 출력하기
//		while (true) {
//			String str = br.readLine(); // 한줄 씩 읽어온다.
//			if (str == null)
//				break;
//			System.out.println(str);
//		}
//		br.close();

		
		
		
		//방법 2 ==> URL객체의 openStream()메서드 이용하기
		InputStream is2 = url.openStream();
		
		InputStreamReader isr = new InputStreamReader(is2, "UTF-8");

		// 속도를 위해 BUFFER사용
		BufferedReader br = new BufferedReader(isr);

		// 자료를 읽어와 출력하기
		while (true) {
			String str = br.readLine(); // 한줄 씩 읽어온다.
			if (str == null)
				break;
			System.out.println(str);
		}
		br.close();

		
	}
	
	

}
