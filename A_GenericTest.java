package genericTest;



//제네릭을 사용하지 않는 클래스

class NonGenericClass{

	//object타입 : 어떤 타입이든 저장가능 
	
	private Object val;
	
	public void setVal(Object val) {
		this.val = val;
	}
	
	public Object getVal() {
		return val;
	}
	
}
		
		/*
		  제네릭을 사용하는 클래스를 만드는 방법
		 
		 형식 )
		 class 클래스명 <제네릭 타입글자,...>{
		 	제네릭타입글자 변수명;			// 변수 선언에 제네릭을 사용할 경우 
		 			 	
		 	
		 	제네릭타입글자  메서드명 (매개변수들...){ //메서드의 반환값으로 제네릭을 사용할 경우 
		 	실행문들....
		 	
		 	return 값;
		 	}
		 	
		 			 	
		 	반환값타입 메서드명(제네릭타입글자 변수명){ //메서드의 매개변수에 제네릭을 사용할 경우
		 		실행문들....
		 		
		 		return 값;
		 	
		 	}
		 }
		  
		  	
		  	*제네릭타입글자로 사용하는 것들
		  * T ==> Type
		  * K ==> Key
		  * V ==> Value
		  * E ==> Element 
		  
		 */

//제네릭을 사용하는 class
class GenericClass<T>{
	private T val;	//object 대신 T를 사용 
	
	public void setVal(T val) {
		this.val = val;
	}
	
	public T getVal() {
		return val;
		
	}
	
}


public class A_GenericTest {
	


	public static void main(String[] args) {
		
		/* 
		 generic타입의 역할 : 제네릭 타입의 데이터만 저장가능, 끄내올때 형변환을 안해줘도됨 
		 		쓰지않으면 object타입, 끄내올때 형변환 해줘야함
			데이터를 저장할 목적으로 많이 사용
		 -cf ) 상속, 상위클래스로 제한을 할 수 있음 
		 */
		
		
//제네릭 타입을 쓰지 않은 메서드
		//set을 호출하여 데이터를 저장함
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		//데이터 꺼내기
		String str1 = (String)ng1.getVal();		//형변환을 반드시 해주어야 한다.
		System.out.println("문자열 반환값 str1 = " + str1);
		
		int num1 = (Integer)ng2.getVal();
//		String str2 =(String)ng2.getVal(); 문법상으로는 오류가 아니나 실행하면 형변환 오류로 에러 발생 (유의)
		System.out.println("문자열 반환값 str2 = " + num1);
		
		//형변환을 할 때 맞는 자료형으로 해줘야한다.(Cast)
		
		
//제네릭 타입을 사용한 메서드
		
		//t의 자리에 String 사용  => t의 자리를 String으로 컴파일러가 바꿔줌 
		GenericClass<String> gc1 = new GenericClass();
		GenericClass<Integer> gc2 = new GenericClass();
		
		//gc1은 String
		gc1.setVal("우리나라 ");
//		gc1.setVal(100); 제네릭에 지정한 타입이 아님 -> 컴파일오류
		
		//gc2는 Integer
		gc2.setVal(200); 
		//gc2.setVal("가나다라") => 컴파일 오류
		
		
		//데이터를 꺼내올 때 
		String str2 = gc1.getVal();
		int num2 = gc2.getVal();
		
		System.out.println("제네릭 문자열 반환값 : " +  str2);
		System.out.println("제네릭 정수형 반환값 : " + num2);
		
		
		

	}

}
