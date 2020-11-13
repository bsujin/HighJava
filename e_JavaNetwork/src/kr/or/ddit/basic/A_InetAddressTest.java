package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class A_InetAddressTest {

	public static void main(String[] args) throws  UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		// www.naver.com의 IP정보 가져오기
		
		//예외처리를 해줘야 컴파일에러가 생기지 않는다. 
		InetAddress naverIp = InetAddress.getByName("www.daum.net");
		
		System.out.println("HostName : " + naverIp.getHostName());
		System.out.println("HostAddress : " + naverIp.getHostAddress());
		System.out.println();
		
		
		//자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		
		System.out.println("내 컴퓨터의 HostName : " + localIp.getHostName());	//컴퓨터의 이름
		System.out.println("내 컴퓨터의 HostAddress : " + localIp.getHostAddress());
	
		//IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
		
		//배열의 개수만큼 반복해서 가져오기 
		for(InetAddress nIp : navers) {
			System.out.println(nIp.toString());
			
		}
		System.out.println();
		

		//IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		
		//배열의 개수만큼 반복해서 가져오기 
		for(InetAddress dIp : daum) {
			System.out.println(dIp.toString());
			
		}
	
		System.out.println();
	
	
	}

}
