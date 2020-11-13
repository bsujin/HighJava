package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class A_URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		// URL 클래스 ==> 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 다루는 클래스
		
		//http://ddit.or.kr:80/index.html?ttt=123
		//					   폴더경로- 가져올 문서 
		
		
		
//		URL객체 만들기
		URL url1 = new URL("http://ddit.or.kr:80/index.html?ttt=123");
//		URL url2 = new URL("http:","ddit.or.kr",80,"index.html?ttt=123");
						   //프로토콜   도메인명  포트번호  경로명 
		
		
		//url 정보 가져오기 
		System.out.println("Protocol : " + url1.getProtocol());
		System.out.println("Host : " + url1.getHost());
		System.out.println("Port : " + url1.getPort());
		System.out.println("File : " + url1.getFile());
		System.out.println("Path : " + url1.getPath());
		System.out.println("Query : " + url1.getQuery());
		System.out.println();
		
		System.out.println(url1.toExternalForm());
	}

}
