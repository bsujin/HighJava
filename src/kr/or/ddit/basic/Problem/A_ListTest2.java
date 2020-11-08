package kr.or.ddit.basic.Problem;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class A_ListTest2 {

	private static Scanner sc;

	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<>();

		sc = new Scanner(System.in);

		/*
		 * 문제 1: 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 이들 중에서 '김'씨 성을 가진 사람의 이름을 모두 출력하시오
		 * (입력은 Scanner객체를 이용한다)
		 */

		 for (int i = 0; i <= 4; i++) {
		 System.out.println("이름을 입력 해주세요");
		 System.out.println("입력>");
		 String input = sc.next();
		 name.add(input);
		 }System.out.println("이름의 목록은 :" + name);
		 String strArr[] = name.toArray(new String[0]);
		 for(int i = 0; i< name.size(); i++) {
		 String kim = name.get(i); //여기서 저장해줌
		 if (kim.contains("김")&&kim.indexOf("김")==0)
		 //contains만 할 경우 전체 다 출력됨 (김이 포함된 모두다- 김이 중간에 있어도 출력됨)
		 System.out.println("김이 포함되는 것은:"+ kim);
		 }
		
		// substring 사용도 가능

		/*
		 * 문제2 : 5명의 별명을 입력 받아서 ArrayList에 저장한 후에 이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오 (단, 각 별명의
		 * 길이는 모두 다르게 입력한다) 길이를 출력하여 비교하기
		 */
		ArrayList<String> alias = new ArrayList<>();
		ArrayList<String> alias2 = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			System.out.println("별명을 입력 해주세요");
			System.out.println("입력>");
			String input = sc.next();
			alias.add(input);
			// alias2.add(input);
		}
		System.out.println(alias);

		String max = null;
		int min = 0;
		for (int i = 0; i < alias.size(); i++) {
			String as = alias.get(i);
			if (as.length() > min) {
				min = as.length();
				max = alias.get(i);
			}
		}
		System.out.println(max);

		
//		
//		for (int i = 0; i <= 4; i++) {
//			System.out.println("별명을 입력 해주세요");
//			System.out.println("입력>");
//			String input = sc.next();
//			alias.add(input);
//		}
//		for (int i = 0; i< alias.size(); i++) {
//			 String as = alias.get(i);
//			 if(as.length()>min) {
//			 min = as.length();
//			 alias2.clear();
//			 alias2.add(alias.get(i));
//			 }
//			 } for(String asas : alias2)
//		System.out.println(asas);
		
		
		
		
//		Object[] str = alias.toArray();
//		for (int i = 0; i < alias.size(); i++) {
//			String as = alias.get(i);
//			if (as.length() > min) {
//				min = as.length();
//				max = alias.get(i);
//				str[i] = alias.set(i, max);
//				System.out.println("값 :" + str[i]);
//			}
		
		
		
		/*
		 * 문제 3 : 문제 2에서 별명의 길이가 같은것이 여러개 있을 경우를 처리하시오 (즉, 제일 긴 별명 모두 출력한다)
		 *
		 */


//		 ArrayList<String> alias2 = new ArrayList<>();
		
//		 alias2.clear();
		for (int i = 0; i <= 4; i++) {
			System.out.println("별명을 입력 해주세요");
			System.out.println("입력>");
			String input = sc.next();
			alias.add(input);
		}
		for (int i = 0; i < alias.size(); i++) {
			String as = alias.get(i);
			if (alias.get(i).length() > min) {
				min = alias.get(i).length();
				alias2.clear();
				alias2.add(alias.get(i));
			} else if (alias.get(i).length() == min) {
				alias2.add(alias.get(i));
			}
			
		}System.out.println("2번 : " +alias2);
		
		for (int i = 0; i< alias.size(); i++) {
			 String as = alias.get(i);
			 if(as.length()>min) {
			 min = as.length();
		
//			 alias2.add(alias.get(i));
			 }
		}
		for(int j = 0; j<alias.size(); j++) {
			if(min==alias.get(j).length()) {
			alias2.add(alias.get(j));
				 }
			 }System.out.println(alias2);
			 	
		
		
		
}
}
	

