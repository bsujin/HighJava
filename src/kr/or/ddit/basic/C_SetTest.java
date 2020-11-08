package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class C_SetTest {

	public static void main(String[] args) {
		/*
		 	- List와 Set의 차이점
		 	
		 	1. List	(ex. 책꽂이) 
		 		- 데이터의 순서(index)가 있다.
		 		- 중복되는 데이터를 저장할 수 있다.
		 	2. Set	(ex. 주머니)
		 		- 데이터의 순서(index)가 없다.
		 		- 중복되는 데이터를 저장할 수 없다.
		 	
		 */
		
		//set의 종류 : HashSet
		HashSet hs1 = new HashSet<>();	//제네릭을 쓰지 않으면 object형 
		
		
		// Set에 데이터를 추가할 때 add()메서드를 사용한다.
		//add()메서드의 반환값 : true, 중복되는 데이터 false
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		
		System.out.println("Set 데이터 : " + hs1);	//입력한 순서대로 데이터가 나오지않음
		
		System.out.println("Set의 개수 : " + hs1.size());
		
		
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		System.out.println();
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않은 데이터 : "+ isAdd);
		System.out.println("Set 데이터 : " + hs1);
		
		System.out.println();
		isAdd = hs1.add("CC");
		System.out.println("중복될 때  : " + isAdd);
		System.out.println("Set 데이터 : " + hs1);
		
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 
		// 수정하려는 데이터를 삭제한 후에 새로운 데이터를 추가하는 방법
		
		/*삭제하는 메서드 : remove(삭제할 데이터)
		 		 반환값 : 삭제성공(true), 삭제실패(false)
		  전체 자료 삭제 메서드 : clear()  		 */
		
		// "FF"데이터를 "EE"로 변경하기 (FF를 지우고 E로 따로 추가)
		System.out.println();
		hs1.remove("FF");
		System.out.println("FF를 삭제 후 Set 데이터 : " + hs1);
		hs1.add("FF");
		System.out.println("다시 추가 후 Set 데이터 : " + hs1);
		
		System.out.println();
//		hs1.clear();
//		System.out.println("clear 후 Set 데이터 : " + hs1);
		
		
		/*
		 	Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다. 
		 	그래서 데이터를 하나씩 얻기 위해서는 Iterator형의 객체로 변환해야 한다.
		 
		 	- Set형의 데이터들을 Iterator형 객체로 변환해주는 메서드 ==> Iterator()
		 		=> 컬렉션에서 사용하는 모든 객체들의 출력을 표준화해줌 
		 */
		
		
		Iterator it = hs1.iterator();	// Set 데이터를 Iterator로 변환하기
		
		
		
		//데이터를 가리키는 어떤 장치 : 포인터  -> 포인터는 처음에 위에 위치 , 밑에 메서드를 사용하여 자리로 옮겨준 다음 데이터가 있으면 꺼내온다
		
		/*
		 * Iterator의 hasNext()메서드
		 	==> Iterator의 포인터가 가리키는 곳의 다음번째 자리에 데이터가 있으면 true, 없으면 false를 반환한다.	
		 
		 * Iterator의 next()메서드
		 	==> Iterator의 포인터를 다음번째 위치로 이동한 후 그 곳의 데이터를 반환한다. 
		 	
		 	--> 반복문을 사용하여 데이터를 꺼내오기 
		 
		*/
		
		
		//hs1.set데이터를 끄내오기
		
		System.out.println("\n-------------데이터 끄내오기-------------\n");
		while(it.hasNext()) {
			System.out.println(it.next());
		} 
		
		
		System.out.println("\n-----------향상된 for문 사용 -------------\n");
		//향상된 for문을 사용하면 Iterator를 사용하지 않고 처리 할 수 있다.
		for(Object obj : hs1) {
			System.out.println(obj);
		}
		
		//set의 중요한 특징 : 중복되는 데이터를 사용하지 않도록 할때 유용 (ex.추첨)
		//set이 없으면 난수 만들고, 일일히 비교해야함  -> 초급자바내용
		
		
		
		/*
		  					문제
		우리반 학생들 중 번호를 이용하여 추첨하는 프로그램 작성하기 
		번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		당첨자를 출력하시오.
			=> 1~25번까지 중복되지 않은 난수 3개 만들기
		*/

		/*
		   최소값~최대값 사이의 난수만들기(난수만드는 공식)
		   (int)(Math.random() * (최대값-최소값+1) + 최소값)
		 */
		
		
		//3보다 작으면 반복하도록 하는 while문 
		HashSet<Integer> testSet = new HashSet<>();
		
		while(testSet.size()<3) {
//			testSet.add(난수)
			testSet.add( (int) (Math.random() * 25) +1 ) ;
		} 
		System.out.println("당첨자 번호 : " +  testSet);
		
	
		
		// Set 유형의 자료를 List형으로 변환하기
		
		ArrayList<Integer> testList = new ArrayList<>(testSet);		//set에 있는 데이터를 ArrayList로 가져오기
		
		System.out.println();
		System.out.println(" List데이터 출력 ");
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		
		
		
		
		
		
		
		
	
	}

}
