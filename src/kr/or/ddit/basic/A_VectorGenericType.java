package kr.or.ddit.basic;

import java.util.Vector;

public class A_VectorGenericType {

	public static void main(String[] args) {
		
		/* 제네릭타입 (Generic Type) --> 객체를 선언할 때 < > 괄호 안에 그 Collection이 
			사용할 데이터의 타입을 정해주는 것을 말한다.
			이런식으로 객체를 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다 
			단, 제네릭으로 선언될 수 있는 데이터 타입은 클래스형 이어야한다.
			
			
			그래서, int는 INTEGER, boolean은 Boolean, char은 Character등으로 대체해서 사용해야한다.
			제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환이 필요없다.
			
		*/
		
		Vector<String> v2 = new Vector<String>();	//String만 저장할 수 있는 Vector객체를 선언
		Vector<Integer> v3 = new Vector<>();		//int형 데이터만 저장할 수 있는 Vector 객체 선언 (<>안에 int가 아니라 INTEGER)
		
		System.out.println(v2);
		v2.add("안녕하세요");
		// v2.add(123); //제네릭의 데이터 타입과 맞지 않아서 추가가 되지 않음 => 오류 : 제네릭 타입과 맞지 않은 데이터를 저장할 수 없다. 
		System.out.println(v2);
		
		String temp = v2.get(0);	//형변환을 하지 않아도 가능 
		System.out.println(temp);
	
		//이중으로 vector 가능 -> Vector 안에 Vector
		//실제로 사용하는 경우가 없음, 알고만 있기
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		
		//데이터 전체 삭제 : clear();
		
		System.out.println("\n clear전의 size : " + v2.size());
		v2.clear();
		System.out.println("v2의 clear size : " + v2.size());
		
		System.out.println("-----------------CLEAR----------------------");
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		v2.clear();
		System.out.println("clear:"+v2);

		Vector<String> v4 = new Vector<>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("/n v2 : " + v2);
		System.out.println(" v4 : " + v4); 
		
		
		//데이터 삭제 : removeAll (Collection 객체)
		// ==> 'Collection 객체'가 가지고 있는 데이터를 Vector에서 찾아서 모두 삭제한다.
		// ==> 반환값 : 작업성공(true), 작업실패(false)
		
		// v2에서 v4와 같은 데이터가 삭제된다 .
		
		
		System.out.println("-----------------remove---------------------");
		
		v2.removeAll(v4);
		
		System.out.println(" 삭제 후 v2 : " + v2);
		System.out.println(" 삭제 후 v4 : " + v4 );
		
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		
		// 벡터의 데이터를 순서대로 가져와 모두 사용하고 싶으면 반복문을 사용하면 된다.
		// 주로 for문, get(index)을 사용한다.
		
		
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : " + v2.get(i) );
		
		}
		System.out.println("-------------------------------------------");
		
		//향상된 for문	(vector의데이터 타입 변수선언 : collection, 배열 )
		//무조건 처음부터 순서대로  데이터를 꺼내서 데이터를 처리하고 싶을 때 사용 , index사용 x -> 일반적인 for문은 index 
		
		for(String str : v2) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
	
	}

}
