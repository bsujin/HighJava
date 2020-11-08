package kr.or.ddit.basic.Problem;
/*
 * 문제 3 : 문제 2에서 별명의 길이가 같은것이 여러개 있을 경우를 처리하시오 (즉, 제일 긴 별명 모두 출력한다)
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class A_ListTest2_Sem3 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList<>();
		
		System.out.println("별명을 5번 입력하세요.");
		for(int i=1; i<=5; i++) {
			System.out.println(i+" 번째 별명 :");
			String alias = scan.next();
			aliasList.add(alias);
		}
		System.out.println();
		
		/* 제일 긴 별명의 글자 수가 저장될 변수를 선언하고
		 * List의 첫번째 데이터의 글자 수로 초기화한다. 
		 */
		//글자 '수'를 저장할 변수 ( 중복될 수 있으므로)
		int maxLength = aliasList.get(0).length();
		
		for (int i = 0; i < aliasList.size(); i++) {
			if(maxLength < aliasList.get(i).length()) {
				 maxLength = aliasList.get(i).length();
				 //여기까지는 제일 긴 글자의 수를 구한것
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for(int i=0; i<aliasList.size(); i++) {
			if(aliasList.get(i).length() == maxLength) {
				System.out.println(aliasList.get(i));
			}
		}
		
		
		
		
		

	}

}
