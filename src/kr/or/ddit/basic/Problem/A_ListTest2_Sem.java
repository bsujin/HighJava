package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * 문제 1: 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 이들 중에서 '김'씨 성을 가진 사람의 이름을 모두 출력하시오
 * (입력은 Scanner객체를 이용한다)
 */


public class A_ListTest2_Sem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String>nameList = new ArrayList<>();
		
		System.out.println("5명의 이름을 입력하세요.");
		for(int i=1; i<=5; i++) {
			System.out.println(i+"번째 사람 이름 : ");
			String name = scan.next();
			nameList.add(name);
		}
		
		System.out.println();
		//김씨인 사람 확인하는 코드
		
		//1번째 방법
		System.out.println("김씨 성을 가진 사람들 ");
		for (int i = 0; i < nameList.size();i++) {
			//i번째의 이름을 끄내와서 비교 
			//substring : 빼올 글자의 시작위치, 뒤에 써있는 숫자 이전까지 가져옴 
			//첫번째의 글자가 "김"인 사람 -> 0,1 1번째 전의 글자를 가져온다
			if(nameList.get(i).substring(0,1).equals("김")) {
				System.out.println(nameList.get(i));
			}
		}

		
		//2번째 방법 (char At)를 사용하면 한글자만 빼옴, 문자 비교는 ==
		//-if(i번째 이름을 가져오는것)은 동일
		for (int i = 0; i < nameList.size();i++) {
			if(nameList.get(i).charAt(0)=='김') {
			System.out.println("2번째 방법 : " + nameList.get(i));
		}
		}
		//3번째 방법 (indexOf사용)
		for (int i = 0; i < nameList.size();i++) {
		if(nameList.get(i).indexOf("김")==0) {
			System.out.println("3번째 방법 : " +nameList.get(i));
			
		}
	}
	
		//4번째 방법 (startsWith - 글자로 시작하는것을 검사함)
		for (int i = 0; i < nameList.size();i++) {
		if(nameList.get(i).startsWith("김")==true) {
			System.out.println("4번째 방법 : " + nameList.get(i));
	}
		}
		
		
		

}
}
