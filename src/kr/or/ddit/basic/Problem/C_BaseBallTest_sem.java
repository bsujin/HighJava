package kr.or.ddit.basic.Problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import kr.or.ddit.basic.ScanUtill;

public class C_BaseBallTest_sem {
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
	ArrayList<Integer> numList;
	ArrayList<Integer> userList;	//사용자가 입력한 값이 저장될 list
	int strike;	//스트라이크 개수가 저장될 변수 
	int ball;	//볼의 개수가 저장되 ㄹ변수 
	
	
	public static void main(String[] args) {
	
//			C_BaseBallTest_sem baseBall = new C_BaseBallTest_sem();
//			baseBall.gameStart();
		
		//다른 방법 -> 하나만 실행시키면 됨 
		new C_BaseBallTest_sem().gameStart();
	
			
	}
	
	//게임이 시작되는 메서드
	public void gameStart() {
		//난수를 만드는 메서드
		getNum();
		//확인용 출력 
		System.out.println("컴퓨터의 숫자 : " + numList);
		
		int cnt = 0;	//몇번만에 맞췄는지를 저장하는 변수 선언 및 초기화 
		
		do {
			cnt++;
			
			//사용자로부터 숫자를 입력받는 메서드
			inputNum();
			System.out.println("user의 숫자 : " + userList);
			
			//볼 카운트 구하는 메서드 호출
			ballCount();
		
		}while(strike!=3);	//스트라이크가 3이 되야 멈춤, 3이 될때까지 반복 
		
		System.out.println();
		System.out.println("축하합니다. ");
		System.out.println("당신은 " + cnt + " 번째 만에 맞췄습니다. ");
	

	}
	
	//1~9사이의 서로 다른 난수 3개를 만들어서 리스트에 저장하는 메서드 (Set이용)
	public void getNum() {
		Set<Integer> numSet = new HashSet<>();
		
		//1~9사이의 중복되지 않는 난수 3개 만들기
		while (numSet.size()<3) {
			numSet.add((int)(Math.random()*9) + 1);
			
		}
		
		//만들어진 난수를 List에 저장하기 
		numList = new ArrayList<>(numSet);
	
		//순서를 섞이게 하기위해 List의 데이터를 섞어준다.
		Collections.shuffle(numList);

	}
	
	//사용자로부터 3개의 정수를 입력받아서 리스트에 저장하는  메서드
	public void inputNum() {
		int n1, n2, n3; // 입력한 정수가 저장될 변수를 선언
		
		//중복이 안될때 까지 반복문
		do {
			
			System.out.println("숫자 입력==>");
			n1 = ScanUtill.nextInt();
			n2 = ScanUtill.nextInt();
			n3 = ScanUtill.nextInt();
			
			//중복  여부 검사 
			if(n1==n2||n2==n3||n1==	n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 숫자를 다시 입력해주세요");
			}
//			else if(n1>9||n1<1)
		}while(n1==n2||n2==n3||n1==n3);	//중복이 되면 다시 입력받기 
		
		//입력받은 순서대로 list에 담기
		userList = new ArrayList<>();//객체 생성을 해줘야함 : 안해주면 null 에러 -> 위에서 생성하면 clear를 해줘야함 
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	
	//스트라이크와 볼을 판정하고 출력하는 메서드
	public void ballCount() {
		//스트라이크와 볼의 개수를 초기화 해줌
		strike =0;
		ball = 0;	
		//스트라이크와 볼의 차이 : 위치 / 값만 같으면 볼
		
		for(int i = 0; i<numList.size(); i++) {
			for(int j=0; j<userList.size();j++) {
				if(numList.get(i)==userList.get(j)) {
					if(i==j) {
						strike++;
					}else {
						ball++;
				}
			}
		}//for문 j
	}	//for문 i
		
		//볼 카운트 결과 출력하기
		System.out.println(userList.get(0) + " , " + userList.get(1) + " , " + userList.get(2) 
		+ " \n " + "===> " + strike +"S" + ball + "B");
		
	
	
	
}
}


