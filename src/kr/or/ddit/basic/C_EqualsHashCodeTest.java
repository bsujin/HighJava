package kr.or.ddit.basic;

import java.util.HashSet;

public class C_EqualsHashCodeTest {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		
		p2.setId(1);
		p2.setName("홍길동");
		
		
		Person p3 = p1;
		System.out.println( p1 == p2 ); 	//결과 : false
		System.out.println( p1 == p3);		//결과 : true
		System.out.println(p1.equals(p2));  //결과 : false
		/*
		 equals로 문자열을 비교하였는데, false가 나오는 이유 : 
		1. 상속을 안하면 자동적으로 object를 상속, equals가 object를 상속받아 equals가 사용가능함
		2. Person 클래스 안에 equals를 재정의 해줘야함  
		*재정의 (override)
		
		*/
		
		HashSet<Person> testSet = new HashSet<>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("Set의 크기 : " + testSet.size());
		
		System.out.println();
		System.out.println("-------------hashCode의 값---------");
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 :" + p3.hashCode());
		
		
		
		/*
		 * hashCode는 참조값을 가지고 만든다.
		 
		  - equals()메서드 	==> 두 객체의 내용이 같은지 검사
		  - hashCode()메서드 	==> 두 객체의 동일성을 검사
		   
		  - HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은
		  	객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출하여 비교한다.
		  	그러므로, 객체가 같은지 여부를 결정하려면 hashCode()메서드를 재정의해야한다.
		  	
		  - hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서
		  	 같은 hashcode를 나타낼 수 있다. (자동으로 재정의 해줌)
		  
		 */
		
		
	}

}


class Person{
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//equals 재정의 해주기
	//기준정하기 : 1. 두개의 데이터가 다 같으면 같다라는 기준
	//객체가 갖고있는 값과 매개변수 값을 비교 , 매서드 안의 내용만 바꿔서 처리해주기
	//매개변수타입이 object로 된 이유 : 매개변수의 값이 정해져 있으면 안됨
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(obj==null) 
//			return false;
//		
//		//객체 유형과 비교(같은 유형의 클래스인지 검사)
//		if(this.getClass() != obj.getClass())
//		return false;
//		
//		//참조값(주소값)이 같은지 검사
//		if(this==obj)
//		return true;
//		
//		//내부 변수 검사
//		//person 유형으로 형변환해주기 (매개변수의 객체를 현재 객체 유형으로 형변환한다.)
//		Person myObj = (Person)obj;
//		if(this.name==null && myObj.name != null) {
//			return false;
//		}
//		//id도 같고 이름도 같을때 
//		if(this.id==myObj.id && this.name == myObj.name) {
//			return true;
//		}
//
//		//문자열을 비교해줌
//		if(this.id==myObj.id && this.name.equals(myObj.name)) {
//			return true;
//		}
//		
//		return false;
//		}		
		
	
	//HashCode -> 자동으로 재정의 해주는 방법
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
		
	
	
	
}