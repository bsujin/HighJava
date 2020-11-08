package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class C_BaseBallTest {


/* 1~9까지 난수 만들기 : set사용
 * 순서가 맞는지 파악하기 위해 list로 저장
 * list의 값을 비교 
 * 입력받은 값도 list에 저장
 * 
 * 
 * - 기능별로 매서드들을 따로따로 만들기
 * 
 * 
 * 문제 ) Set과  List를 이용하여 숫자야구 프로그램을 작성하시오
 * 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 * 		(스트라이크는 S, 볼은 B로 나타낸다)
 * 	예시) 컴퓨터의 난수 ==> 957
 * 		3s 면 게임 끝
 * 
 * 실행예시) 숫자입력 ==> 3,5,8
 * 		   3 5 8 ==> 1s 0b
 * 		     숫자입력 ==> 7 8 9 
 * 		   7 8 9 ==> 0s, 2b
 * 	           숫자입력 ==>
 * 	 	  9 7 5 ==> 1s, 2b
 * 		 숫자입력 ==> 9,5,7
 * 		 9 5 7 ==> 3s
 *	축하합니다. 당신은 4번째 만에 맞췄습니다.
 */



	public static void main(String[] args) {
	
		HashSet<Integer> random = new HashSet<>();
		random.add((int)(Math.random()*9)+1);
		
		List<Integer> computer = new ArrayList<>(random);
		List<Integer> user = new ArrayList<>();
		
		
		
		
	}

	
	
	
}


