package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class B_ListSortTest2 {
	
	//생성자를 자동으로 만들어 주는 기능 (alt + shift + s)
	
	public static void main(String[] args) {
	//Member 클래스의 타입으로 배열을 만들어줌 
	ArrayList<Member> memList = new ArrayList<>();
	
	memList.add(new Member(1,"홍길동","010-1111-1111"));
	memList.add(new Member(5,"이순신","010-1111-1111"));
	memList.add(new Member(10,"성춘향","010-1111-1111"));
	memList.add(new Member(2,"변학도","010-1111-1111"));
	memList.add(new Member(3,"강감찬","010-1111-1111"));
	memList.add(new Member(6,"일지매","010-1111-1111"));
	memList.add(new Member(2,"이몽룡","010-1111-1111"));
	
	System.out.println("처음 데이터...");
	for(Member mem : memList) {
		System.out.println(mem);
		
	}
	
	System.out.println("\n----------------------------------------------------\n");
	
	//리스트에 넣은 데이터를 정렬 - 내부정렬은 하나만 가능 -> 외부정렬 기준 만들면 됨 
	Collections.sort(memList);	//그냥 넣어주면 컴파일에러 - 지원이 안되는 데이터 (맨 밑에 오버라이딩) 
	System.out.println("회원이름의 오름차순 정렬 후..");
	for(Member mem : memList) {
		System.out.println(mem);
	}
	
	System.out.println("\n----------------------------------------------------\n");

	
	//외부정렬기준
	Collections.sort(memList, new SortNumDesc());
	System.out.println("회원 번호의 외부정렬(내림차순) 정렬 후 ..");
	for(Member mem : memList){
		System.out.println(mem);
	}
	
	System.out.println("\n------------------------------------------------------\n");
	
	
	}
}

/*
 *  사용자가 작성하는 클래스 내부정렬기준을 지정하려면,
    Comparable 인터페이스를 구현해서 작성해야한다.
   	(내부정렬기준을 넣어서 클래스를 작성한다.)
   	예) implements Comparable<Member> 사용
   	
   	Comparable 인터페이스는  compareTo()메서드가 선언되어 있다.
   	그래서, 이 compareTo() 메서드를 재정의해서 정렬 기준을 지정한다.
   
   	예) Member클래스의 회원이름을 기준으로 오름차순이 되도록 하는 내부정렬기준 추가하기
   	(Comparable 인터페이스를 구현해서 작성한다.)
 */

class Member implements Comparable<Member>{ 
	private int num;
	private String name;
	private String tel;
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	//내부정렬 기준 만들기
	//sort- 컴파일 에러 해결 : 현재 member와 매개변수에 있는 mem을 비교 (매개변수 1개)
	
	@Override
	public int compareTo(Member mem) {
		
		//방법 2가지
//		return this.name;
		return this.getName().compareTo(mem.getName());
		//현재 데이터.compare to(매개변수에 있는 데이터)
	}

	
}
//Member클래스의 회원번호(num)의 내림차순으로 정렬할 외부 정렬 기준 크래스 작성 


class SortNumDesc implements Comparator<Member>{

	
	//(앞에데이터, 뒤에데이터)
	@Override
	public int compare(Member mem1, Member mem2) {

		//1.첫번째 방법
		
//		if(mem1.getNum() > mem2.getNum()) {
//			return -1; 				//앞에 데이터의 순서가 크면 음수(자리를 바꾸지않음)
//		}else if(mem1.getNum() == mem2.getNum()) {
//			return 0;
//		}else 
//			return 1;				// 양수를 반환하면 순서가 바뀐다
//	
		//2. 2-1 Wrapper 클래스를 이용하는 방법(compare To를 사용하려면)
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
		//2-2 Wrapper 클래스 이용 (compare 사용)
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
	}
	
}
