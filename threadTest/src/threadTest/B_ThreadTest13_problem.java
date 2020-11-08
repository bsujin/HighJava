package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
  	문제) 10마리의 말들이 경주하는 경마 프로그램 만들기
  	
  		경주마는 Horse라는 이름의 클래스로 구성하고
  		이 클래스는 말 이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
  		
  		그리고, 이 클래스에는 등수를 오름차순으로 처리하는 내부 정렬 기준이 있다.
  			  (Comparable인터페이스 구현하기)
  		
  		- 이 Horse클래스는 쓰레드로 작성한다.
  		
  		- 경기 구간은 1 ~ 50구간으로 되어 있다.
  		
  		- 경기 중 중간 중간에 각 말들의 위치를 나타내시오.
  		
  		예) 1~50구간 : 일정한 시간을 가지고 계속 반복 
  		01번 말 : ------>-----------------------------------------
  		02번 말 : --->-------------------------------------------
  		...
  		10번 말 : -------->--------------------------------------
  		
  		- 경기가 끝나면 등수 순으로 경기 결과를 출력한다.
 */

public class B_ThreadTest13_problem {

	//private static Horse[] horses;

	public static void main(String[] args) {

		// List<Horse> horse = new ArrayList<Horse>();

		Horse[] Horeses = new Horse[] { new Horse("1번말"), new Horse("2번말"), new Horse("3번말"), new Horse("4번말"),
				new Horse("5번말"), new Horse("6번말"), new Horse("7번말"), new Horse("8번말"), new Horse("9번말"),
				new Horse("10번말")

		};

		// 시작
		for (Horse horses : Horeses) {
			horses.start();
		}
		
		GameStart g = new GameStart(Horeses);
		g.start();

		for (Horse horses : Horeses) {
		try {
				horses.join();
				g.work = false;
				
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		}
		
		System.out.println();
		System.out.println("경기 결과 : " );
		
		for(int i = 0; i<Horse.r.length; i++) {
			System.out.println(i+1 + " 등  : " + Horse.r[i]);
		}
		
		
		}
		

	}


// horse를 출력하는 쓰레드 만들기

class Horse extends Thread{

	public String name;
	public static int rank = 0;
	public int state;
	public static String[] r = new String[10];

	// 생성자
	public Horse(String name) {
		this.name = name;
		// this.rank = rank;
		// this.state = state;
	}

	@Override
	public void run() {

		// 말의 순서만큼 반복하기
		// - 경기 중 중간 중간에 각 말들의 위치를 나타내시오.

		for (int j = 1; j <= 50; j++) {
		try {
			Thread.sleep((int) (Math.random() * 400) + 101);
				state = j;
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		}
//		System.out.println(name + "도착!");
		
		// 등수를 결정해서 rank에 저장
		Horse.r[Horse.rank] = name;
		Horse.rank++;
		
	}

}

// 경기 상태를 출력하는 쓰레드
class GameStart extends Thread{
	Horse[] horses;
	public boolean work = true;
	public GameStart(Horse[] horses) {
		super();
		this.horses = horses;
	}

	public Horse[] getHorse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// - 경기 중 중간 중간에 각 말들의 위치를 나타내시오.
		while(true) {
			if(work==false) {
				System.out.println("경기가 끝났습니다.");
				break;		
			}else {
		try {
			Thread.sleep(1000);
			
			
		} 
		catch (InterruptedException e) {
		}
		
		
		for (Horse h : horses) {
			
			System.out.println(h.name + "말 ");
			
			for (int j = 1; j <= 50; j++) {
				System.out.print("-");
				if (j == h.state) {
					System.out.print(">");
				}
		}
			System.out.println();
		}
		System.out.println();
	}
	}
	}
}
