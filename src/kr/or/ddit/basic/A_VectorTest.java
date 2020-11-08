package kr.or.ddit.basic;

import java.util.Vector;

public class A_VectorTest {

	public static void main(String[] args) {
		Vector v1 = new Vector();
		
		System.out.println("크기 : " + v1.size());
		
		//데이터 추가 : add(추가 할 데이터)
		// 반환값 : 추가성공(true), 실패 (false)
		
		v1.add("aaaa");	//문자반환
		v1.add(new Integer(111));	//숫자 반환 -래퍼클래스를 기본으로 형변환하여 추가 (오토언박싱)
		
		v1.add(123);	//현재는 이렇게 사용 
		//기본타입이 래퍼 클래스로 자동으로 변환 -오토박싱
		
		v1.add('a');
		v1.add(true);
		
		boolean r = v1.add(3.14); //double(8) 의미
		System.out.println("현재 크기 : " + v1.size());
		System.out.println("반환값 : " + r);
		System.out.println("=====================================");
		
		// 데이터 추가 2 : addElement(추가할 데이터) ==> 이전 버전에서 사용하던 메서드
		// 이전 버전의 프로그램도 사용할 수 있도록 하기 위해서 남아있는 메서드 
				//add = Element 같은 개념 
		
		v1.addElement("CCC");
//		System.out.println("V1 : " + v1.toString());
		System.out.println("V1 :"+ v1);  //위에와 같은 값 , 이렇게도 사용가능
		
		v1.get(2);
		System.out.println(v1.get(2));
		System.out.println("===================================");
		
		
		//데이터 추가 3 : add(index, 데이터)
		// ==> 'index'번째에 새로운 '데이터'를 끼워 넣는다.
		// ==> 'index' 는  0부터 시작한다.
		// ==> 반환값이 없다.
		
		v1.add(1, "KKK");
		System.out.println(v1);
		
		//데이터 수정 : set(index, 데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터(변경 전의 데이터)
		
		//0번 인덱스의 값 바꾸기
		v1.set(0,"zzz");
		
		
		//String temp =v1.set(0,"zzz");			-> 에러(이유 : 타입)
		//vector 객체에 object타입의 데이터를 저장함 -> 반환값이 object 이어야함 
	
		String temp = (String)v1.set(0,"zzz");	//object 타입이므로 형변환 해줌 
//		Object temp =v1.set(0,"zzz");
		System.out.println(temp);	
		System.out.println("v1 : " + v1);
		System.out.println("반환값(원래의 데이터) :  " + temp); 
		System.out.println("================================");
		
		
		//데이터 삭제 1: remove(index)
		// ==> 'index'번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		
		v1.remove(2);
		Integer delete = (Integer)v1.remove(2);
		System.out.println("삭제후 v1 : " + v1);
		System.out.println("반환값(원래의 데이터) : " + delete);
		System.out.println();
		
		v1.add(123);
		//데이터 삭제 2 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개면 앞에서부터 한번에 하나씩 삭제된다
		// ==> 반환값 : 삭제성공(true), 삭제 실패(false)
		
		v1.add("CCC");
		System.out.println(v1);
		v1.remove("CCC");
		System.out.println("삭제 후 v1 : " +v1);
		System.out.println();
	
		
//		==> 삭제 할 데이터가 '정수형' 이거나 'char형'일 경우에는 반드시 객체형으로 변환해서 사용해야 한다.
		
		//정수형일 경우 		
//		v1.remove(123);
//		System.out.println("삭제 후 v1 : " + v1);
//		==> Array index out of range: 123 -> 오류 : 데이터의 값이 아니라 인덱스로 생각함 
// 		==> 오토박싱이 되지않아 객체화를 시켜줘야한다.

		
		v1.remove(new Integer(123));
		System.out.println("123 삭제후  v1 : " + v1);
		System.out.println();
		
		
// char일 경우
//		v1.remove('a');
//		System.out.println("삭제후 v1 : " + v1);
		v1.remove(new Character('a'));
		System.out.println("삭제후 v1 : " + v1);
		
		v1.remove(3.14);
		System.out.println(v1);
		v1.remove(true);
		System.out.println("삭제 후 v1 : " + v1);
		
		// 데이터 꺼내오기 : get(index)
		// ==> 'index'번째 데이터를 반환한다.
		
		String data = (String)v1.get(0);
		System.out.println("0번째 자료 : " + data);
		
		
		
		
		

	}

}
