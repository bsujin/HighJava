package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 문제) 학번(int), 이름 (String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
 	 Student 클래스를 만든다.
 	  이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로
 	  받아서 초기화 처리를 한다.
 	 
 	 - 이 Student 객체는 List에 저장하여 관리한다.
 	
 	 - List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 	      총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
 	      외부정렬기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 	   
 	   (단, 등수는 List에 전체 데이터가 추가 된 후에 저장되도록 한다.)
 */

public class B_ListSortTest3 {
////등수를 구하는 메서드
//public void setRanking(List<Student>stdList) {
//	for(Student std : stdList) {	//기준데이터를 구하기 위한 반복문
//		int rank =1;				//처음에는 1등으로 설정해놓고 시작한다.
//		for(Student std2 : stdList) {	//비교대상을 나타내는 반복문
//			
//			//기준보다 비교대상의 값이 크면 rank값을 중가한다 
//			if(std.getTotalScore()<std2.getTot()) {
//				rank++;
//			}
//			
//		}
//		//구해진 등수를 Student객체의 변수에 저장한다.
//		std.setRank(rank);
//	}
	
	public static void main(String[] args) {
		
		
//ListSortTest3 stdList = new ArrayList<>(); 
//		등수구하는 메서드를 호출해서 등수를 구한다
//		stdTest.setRank(stdList)
		
		
		
		ArrayList<Student> gradeCard = new ArrayList<>();
		gradeCard.add(new Student(1, "가가가"	, 50, 20, 30));
		gradeCard.add(new Student(3, "나나나", 20, 40, 23));
		gradeCard.add(new Student(8, "다다다", 30, 30, 33));
		gradeCard.add(new Student(7, "라라라", 40, 50, 40));
		gradeCard.add(new Student(5, "마마마", 60, 60, 30));
		gradeCard.add(new Student(6, "바바바", 60, 70, 20));
		gradeCard.add(new Student(2, "사사사", 70, 80, 40));
		gradeCard.add(new Student(9, "아아아", 80, 90, 50));
		gradeCard.add(new Student(10, "자자자", 90, 70, 70));
		gradeCard.add(new Student(4, "차차차", 100, 85, 40));

		System.out.println("-------처음 데이터-------- ");
		for (Student st : gradeCard) {
			System.out.println(st);
		}

		// 리스트에 넣은 데이터를 내부정렬
		System.out.println();
		Collections.sort(gradeCard);
		System.out.println("-------학번으로 오름차순 정렬------");
		for (Student st : gradeCard) {
			System.out.println(st);
		}

		// 리스트에 넣은 데이터를 외부정렬
		System.out.println();
		Collections.sort(gradeCard, new SortByTotal());
		System.out.println("-----총점으로 내림차순, 이름으로 오름차순-----");
		for (Student st : gradeCard) {
			System.out.println(st);
		}

		// 등수 입력하기
		System.out.println();
		System.out.println("-----------등수 값 추가하기-------------");
		for (int i = 0; i < gradeCard.size(); i++) {
			int count = 1;
			for (int j = 0; j < gradeCard.size(); j++) {
				if (gradeCard.get(i).getTotalScore() < gradeCard.get(j).getTotalScore()) {
					count++; // j의 값이 크면 더해준다
				}
			}
			gradeCard.get(i).setRank(count);
		}
		for (Student st : gradeCard) {
			System.out.println(st);
		}

		
		//위와 값은 동일하나, sort로 사용하여 등수로 정렬
		System.out.println();
		Collections.sort(gradeCard, new rank());
		System.out.println("---------등수로 정렬하기 --------------");
		for(Student st : gradeCard) {
			System.out.println(st);
		}
		
		
	}

}

class Student implements Comparable<Student> {
	private int studentID;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int Score;
	private int rank;

	public Student(int studentID, String name, int korean, int english, int math) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		Score = korean + english + math;
		this.rank = rank;

	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotalScore() {
		return Score;
	}

	public void setTotalScore(int totalScore) {
		this.Score = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", korean=" + korean + ", english=" + english
				+ ", math=" + math + ", totalScore=" + Score + ", rank=" + rank + "]";
	}

	// 내부정렬
	@Override
	public int compareTo(Student st) {
		return Integer.compare(studentID, st.studentID);

	}
	

}

	//외부정렬
//1. 총점으로 내림차순, 총점이 같으면 이름으로 오름차순 
class SortByTotal implements Comparator<Student> {

	@Override
	public int compare(Student st1, Student st2) {

		if (st1.getTotalScore() == st2.getTotalScore()) {
			return st1.getName().compareTo(st2.getName());
		}
		return Integer.compare(st1.getTotalScore(), st2.getTotalScore()) * -1;
	}

}

class rank implements Comparator<Student>{

	@Override
	public int compare(Student st1, Student st2) {
		// TODO Auto-generated method stub
		return Integer.compare(st1.getRank(), st2.getRank());
	}
	
	

	


	
	
}
