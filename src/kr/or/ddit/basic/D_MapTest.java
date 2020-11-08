package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class D_MapTest {

	public static void main(String[] args) {
	
		/* Map ==> Key값과 value값을 한쌍으로 관리하는 객체
			- key 값은 중복을 허용하지 않고 순서(index)가 없다. (Set의 특징을 갖는다.)
			- value값은 중복을 허용한다.
			
		*/
		
		HashMap<String,String> map = new HashMap<>();
	
		//자료 추가하기 --> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-123-123");
		
		
		System.out.println("map의 데이터 : " + map);
		
		//map은 {}로 표시, key값=value값 => 출력시순서가없다
		
		
		/*
		 자료 수정
		  ==> Map의 데이터를 수정하려면 put()메서드의 key값을 같게해서 추가한다.
				  ==> Map은 key값이 같으면 나중에 추가한 데이터가 남는다. */
		
		System.out.println();
		map.put("addr", "서울");
		System.out.println("map의 데이터 : " + map);
		
		/* 
		  자료 삭제 
		  ==> remove(key값) : key값이 같은 자료를 찾아서 삭제한다.
			반환값 : 삭제된 데이터의 value값이 반환된다. */
		
		
//		System.out.println();
//		String moveTel = map.remove("tel");
//		System.out.println("삭제 후 map : " + map);
//		System.out.println("삭제 된  value값 : " + moveTel);				  
//		
		
		/*	 자료 읽기 
		 	==> get(key값) : key값이 같은 자료의 value값을 반환한다.	 
		 			==> key값이 없을 때에는 null을 반환한다.(null point exception 발생)
		 */
		
		System.out.println("이름 : " + map.get("name"));
		System.out.println("주소 : " + map.get("addr"));
		System.out.println( "전화번호 : " + map.get("tel"));
	
		System.out.println();
		
	
		/* 키값의 유무(존재여부)를 검사  - 
		 	containsKey(key값) ==> 해당 key값이 있으면 true, 없으면 false를 반환한다.
		 	
		 	- get이라는 메서드를 쓰기 전에 키값의 유무를 확인 , map에 저장된 데이터가 많을 때 유용함 
		*/
		
		System.out.println("name 키 값의 존재 여부 : " + map.containsKey("name"));
		System.out.println("name 키 값의 존재 여부 : " + map.containsKey("age"));
		System.out.println();
		
		
		// Map에 저장된 데이터를 차례로 읽어와 데이터를 처리하는 방법
		//방법 1, 2 외워두기, 4번은 참고 
		
		// 방법 1) keySet()메서드 이용하기  (예전에 만든 프로그램에서 주로 많이 사용) 
			//keySet() ==> Map의 Key값들을 읽어와 Set형으로 반환한다.
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next();	//Key값 가져오기
			String value = map.get(key);
			System.out.println(key + " : " + value);
			
		}	System.out.println("\n---------------------------\n");
		
		
	
		// 방법 2 ) keySet()을 향상된  for문으로 처리하기 (많이 사용) 
		for(String key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}	System.out.println("\n---------------------------\n");
		
		
		
		// 방법 3) value값만 읽어와서 처리하기 --> values()메서드 이용
		for(String value : map.values()) {
			System.out.println(" " + value);
		}System.out.println("\n---------------------------\n");
		
		
		/* 
		 방법 4) ==> Map에는 Entry라는 내부 class가 만들어져있다.
		  		   이 Entry클래스는 key와 value라는 멤버변수로 구성되어있다.
		  		   Map에서는 이 Entry 클래스들을 Set형식으로 저장해서 관리한다.

		 	- Entry 객체 전체를 가져와서 처리하기 (==> 가져온 Entry들은 Set형식으로 되어있다.)
			==> entrySet()메서드를 이용 
			
		 */
		
	
		//Entry라는 내부객체 전체 가져오기 
		//제네릭 : map안에 entry -> Iterator, 향상된 for문 이용가능 
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		//Iterator객체 생성
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
		
			//Entry 객체에서 key값과 value값 구하기
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("--------------------------------------------");
	
		
		
	}

}
