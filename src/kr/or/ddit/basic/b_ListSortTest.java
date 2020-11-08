package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class b_ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		//정렬 : 오름차순, 내림차순
		//알고리즘 
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 : " + list); 	//정렬전에는 입력한 순서대로 나옴
		
	//정렬해주는 명령어	
		//정렬은 Collections.sort() 메서드를 이용하여 정렬한다.
		//(문자열의) 정렬은 기본적으로 오름차순으로 정렬을 수행한다. -> 내부정렬방식이 오름차순
		System.out.println("\n---sort 매서드를 사용---");
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		System.out.println("\n---shuffle 매서드를 사용 ---");
		Collections.shuffle(list);
		System.out.println("자료 섞기 후 : " + list);
				
		
		//외부정렬 기준 클래스를 지정해서 정렬하기
		System.out.println("\n---내림차순 정렬(compareTo) 사용 ---");
		Collections.sort(list,new Desc());
		System.out.println("내림차순 정렬 후 : " + list); 
		
		//내림차순 정렬
		//내부 정렬방식(오름차순)을 (내림차순)으로 바꿔줘야함
		//===> 방법 : 정렬방식을 정해주는 Class를 작성한다. (외부 정렬 기준 클래스라고 한다.)
		// 			Comparator인터페이스를 구현해서 작성한다.
	}
}

	class Desc implements Comparator<String>{
		// compare()메서드를 재정의해서 정렬하고자 하는 기준을 정한다.
		/*
		 - compare()메서드의 반환값
				 : 반환값이 0 --> 두 값이 같다.
				 : 반환값이 음수 --> 순서를 변경하지 않는다. 
				 : 반환값이 양수 --> 앞, 뒤 값의 순서를 변경한다. 
		
		예) 오름차순일 경우 ==> 앞의 값이 크면 반환값이 양수, 같으면 0, 뒤의값이 크면 음수 (= return 값)
		
		String 객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데
		이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다. 
			형식 ) 앞 문자열.compareTo(뒤문자열);
		 (Wrapper 클래스와 Date, File클래스에도 구현되어 있다.)
		 
		 */
		
		
		@Override
		public int compare(String str1, String str2) {
		//내림차순으로 정렬되도록 구현하기
			
			//1. if문 사용 
//			if(str1.compareTo(str2) > 0) {
//				return -1;
//			}else if(str1.compareTo(str2)==0) {
//				return 0;
//			}else {
//				return 1;
//			}
//			
			//2. 2번째 방법
			//반환해주는 값에 부호를 반대로 들어가게 함 
			//String만 가능 
			return str1.compareTo(str2) * -1;
			
		}
		
		
		
	
		
		
		
	}


