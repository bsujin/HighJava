package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제2 : 5명의 별명을 입력 받아서 ArrayList에 저장한 후에 이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오 (단, 각 별명의
 * 길이는 모두 다르게 입력한다) 길이를 출력하여 비교하기
 */

public class A_ListTest2_Sem2 {
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList<>();
		
		System.out.println("서로 다른 길이의 별명을 5번 입력하세요.");
		for(int i=1; i<=5; i++) {
			System.out.println(i+" 번째 별명 :");
			String alias = scan.next();
			aliasList.add(alias);
		}
		System.out.println();
		
		/* 생각해보기 
		 * 최대값을 구하는거와 비슷하게 생각하기
		 * 1. 제일 긴 별명이 저장될 변수를 선언하기 => List의 첫번째 데이터로 초기화 한다.(초기화 하면 반복문을 한번 덜 돌려도 됨)
		 *  
		 */
		//문자를 저장해두는 것이 좋음 (코드를 덜 씀)
		String maxAlias = aliasList.get(0); //0번째를 미리 넣어둠 
		for(int i=1; i<aliasList.size(); i++) {						//1번째 부터 시작
		if(maxAlias.length() < aliasList.get(i).length()) {
			maxAlias = aliasList.get(i);
		}					
		}
			System.out.println("제일 긴 별명 : " + maxAlias);
		
		
		
			
		
			
			
			
		

	}

}
