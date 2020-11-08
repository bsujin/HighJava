package kr.or.ddit.basic;

import java.util.ArrayList;

public class A_ListTest {

	public static void main(String[] args) {
	
		//ArrayList는 기본적인 사용법이 Vector와 같다.
		ArrayList list1 = new ArrayList();
		
		//add()메서드를 이용해서 데이터를 추가한다.
		list1.add("sss");
		list1.add("bbb");
		list1.add(123);
		list1.add('s');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("list1의 siz는 " + list1.size());
		System.out.println("list : " + list1);
		
		
		//get() 메서드로 데이터를 꺼내온디.
		System.out.println("1번째 자료 : " + list1.get(1));
		
		list1.add(3,"zzzzz");
		System.out.println("list 1 : " + list1);
		System.out.println();
		
		//데이터 끼워넣기
		String temp = (String)list1.set(3,"XXX");
		System.out.println("temp : " + temp);
		System.out.println("list1" + list1);
		
		//삭제도 같다
		list1.remove(3);
		list1.remove("삭제 후 list1 :" + list1);
		
		list1.remove("bbb");
		System.out.println("삭제후 list : " + list1);
		
		
		
		// 제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		System.out.println("\n제네릭을 사용할 수 있다.");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "==>" + list2.get(i));
		}				

		System.out.println("---------------------------");
		
		for (String str : list2) {
			System.out.println(str);
		}
		System.out.println("-------------------------");
				
		
		
		//contains (비교객체) ==> 리스트에 '비교객체'가 있으면 true, 없으면 false 반환
		System.out.println("DDD값 : " + list2.contains("DDD"));
		System.out.println("zzz값 : " + list2.contains("zzz"));
		
		
		//indexOf(비교객체)
		//==> 리스트에 '비교객체'가 있으면 '비교객체'가 있는 위치의 index값이 반환된다.
		// 있으면 인덱스의 값, 없으면 -1을 반환한다
		System.out.println("\n indexOf() 사용 ");
		System.out.println("DDD의 위치값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 위치값 : " + list2.indexOf("zzz"));
		System.out.println("----------------------------------");
		
		//toArray()
		//==> 리스트 안의 데이터를 배열로 변환하여 반환한다.
		//==> 기본적으로 Object형 배열로 변환한다.
		System.out.println("\n toArray() 사용");
		Object[] strArr = list2.toArray();
		System.out.println("list2의 배열의 개수 : " + strArr.length);
		
		//배열안의 값을 꺼내올 때 for문 사용 
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i + " 번째 자료 : " + strArr[i]);
			
		}
		
		//String 타입으로 바꾸기  -> 그냥 쓰면 에러 발생
		//toArray(new 제네릭타입[0]) -> []안의 숫자는 아무거나 사용가능, [1000]이어도 됨/ 
		//==> 제네릭 타입의 배열로 변환한다.
		System.out.println("=============string  타입 사용 ============");
		String[] strArr1 = list2.toArray(new String[0]);
		System.out.println("list2의 배열의 개수 : " + strArr1.length);
		
		//배열안의 값을 꺼내올 때 for문 사용 
		for (String str : strArr1) {
			System.out.println("배열의 값 :" + str);
			
		}
		
		//변수를 선언해주면, 1차원 배열의 객체를 생성하여 주소를 넣어줌  (ttt로 변수를 주어도 같은 의미)
		String[] ttt = new String[0];
		String[] StrArr2 = list2.toArray(ttt);
		System.out.println(StrArr2.length);
		
//		public void toArray(string[]a) {
//			a = 반환해주는 값을 적어줌 
//		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
