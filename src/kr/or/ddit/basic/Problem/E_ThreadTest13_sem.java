package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E_ThreadTest13_sem {

	public static void main(String[] args) {

		Horse[] horses = new Horse[] { new Horse("01번말"), new Horse("02번말"), new Horse("03번말"), new Horse("04번말"),
				new Horse("05번말"), new Horse("06번말"), new Horse("07번말"), new Horse("08번말"), new Horse("09번말"),
				new Horse("10번말") };

		GameSate gs = new GameSate(horses);

		System.out.println("경기 시작...");
		for (Horse h : horses) {
			h.start();
		}
		gs.start();

		for (Horse h : horses) {
			try {
				h.join(); // 모든말이 경기가 끝날 때 까지 기다려줌
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		try {

			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		System.out.println("경기 끝...");

		/*
		//방법1) 배열을 직접 정렬하고 출력하기 
		
		// 정렬 : 배열도 정렬하는 것을 지원해준다.
		Arrays.sort(horses);

		// 출력
		for (Horse h : horses) {
			System.out.println(h);
		}
		*/
		
		// 방법2) 배열의 데이터를 List에 담고 List를 정렬하여 출력하기 
		ArrayList<Horse> horseList = new ArrayList<>();
		for(Horse h : horses) {
			horseList.add(h);
		}
		
		Collections.sort(horseList);

		for(Horse h: horseList) {
			System.out.println(h);
		}
		
		
	}

}

// 말의 달리는 기능 (전체말이 달리는 것을 구현해야한다-> 하나의 쓰레드로만 할 수 없다.)
class Horse extends Thread implements Comparable<Horse> {
	public static int currentRank = 0; // 말들의 등수를 계산에 사용 되는 변수 선언

	private String horseName; // 말이름
	private int rank; // 등수
	private int positon; // 현재위치

	// 등수와 현재위치는 게임하면서 진행되므로 초기화 해줄 필요 없음
	// 생성자
	public Horse(String horseName) {
		super(); // 있어도 되고 없어도 된다.
		this.horseName = horseName;
	}

	// getter,setter 만들기
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPositon() {
		return positon;
	}

	public void setPositon(int positon) {
		this.positon = positon;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName + "의 등수는  " + rank + "등 입니다.";
	}

	// 등수를 오름차순 - 내부정렬 
	@Override
	public int compareTo(Horse horse) {

		return Integer.compare(rank, horse.getRank()); // 현재등수, 상대편 등수
	}

	// 말이 달리는 부분을 쓰레드로 처리

	@Override
	public void run() {
		// 1부터 50구간
		for (int i = 0; i <= 50; i++) {
			positon = i; // 말의 현재 위치를 저장한다.

			// 다음 구간 갈때까지 지연이 필요
			try {
				Thread.sleep((int) (Math.random() * 500) + 101);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		} // for문 종료

		// 전체 말의 등수(한마리의 말이 경주가 끝나면 등수를 구해서 rank에 설정한다.
		currentRank++;
		this.rank = currentRank;
	}

}

/*
 * 경기 중 중간중간에 각 말들의 위치를 나타내시오.
 * 
 * 예) 1~50구간 : 일정한 시간을 가지고 계속 반복 01번 말 :
 * ------>----------------------------------------- 02번 말 :
 * --->------------------------------------------- ... 10번 말 :
 * -------->--------------------------------------
 * 
 */

// 경기 중 말의 현재위치를 출력하는 쓰레드
class GameSate extends Thread {

	// 위에 있는 배열이 여기에 저장된다.
	private Horse[] ho;

	public GameSate(Horse[] ho) {
		this.ho = ho;
	}

	@Override
	public void run() {
		while (true) {
			// 모든 말들의 경주가 끝났는지 여부를 검사한다.
			// 배열의 길이만큼으로 기준을 해주면 말을 추가하든 삭제해도 가능함
			if (Horse.currentRank == ho.length) {
				break;
			}

			// 빈 줄 출력하기
			for (int i = 1; i <= 15; i++) {
				System.out.println();
			}

			for (int i = 0; i < ho.length; i++) {
				System.out.print(ho[i].getHorseName() + " : ");

				for (int j = 1; j <= 50; j++) {
					if (ho[i].getPositon() == j) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				// 다음말을 출력할 때 줄을 바꿔서 출력하도록 하기
				System.out.println();
			}
			// System.out.println();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

	}

}
