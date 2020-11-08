package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import kr.or.ddit.basic.ScanUtill;

public class C_lotoProgram {

	public static void main(String[] args) {
		new C_lotoProgram().lottoStart();

	}

	// 로또 프로그램이 시작되는 메서드
	public void lottoStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 구매
				break;

			case 2: // 종료
				System.out.println("감사합니다.");
				return;
			// System.exit(0);

			default:
				System.out.println("메뉴번호를 잘못 입력했습니다. 다시 입력해주세요");
				break;
			}
		}

	}

	public int displayMenu() {

		System.out.println();
		System.out.println("=============================");
		System.out.println("\tLotto 프로그램");
		System.out.println("-----------------------------");
		System.out.println("\t1.Lotto 구입");
		System.out.println("\t2.프로그램 종료");
		System.out.println("=============================");
		System.out.println(" 메뉴 선택 >>");

		int num = ScanUtill.nextInt();
		return num;

	}

	// 로또를 구매하는 메서드
	public void lottoBuy() {
		System.out.println(" Lotto 구입 시작 \n");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액 입력 : ");
		int money = ScanUtill.nextInt();

		if (money < 1000) {
			System.out.println("입력금액이 너무 적습니다. 로또 구입 실패!!");
		} else if (money >= 101000) {
			System.out.println("입력금액이 너무 많습니다. 로또 구입 실패!");
		} else {
			//로또번호를 생성해서 출력하는 메서드 호출 
			lottoNum(money);
			//lottoNum의 메서드 내용을 여기다 적어도 상관없음 
		}
	}

	// 로또 번호를 생성해서 출력하고 거스름 돈을 출력하는 메서드 : 금액을 매개변수로 받기
	public void lottoNum(int money) {
		System.out.println("행운의 로또 번호는 아래와 같습니다.");
		// 1부터 해야 1번 부터 나옴(로또 산 갯수만큼 반복)
		for (int i = 1; i < money / 1000; i++) {
			HashSet<Integer> lotto = new HashSet<>();
			while (lotto.size() < 6) {
				lotto.add((int) (Math.random() * 45) + 1);
			}
			ArrayList<Integer> lottoNumber = new ArrayList<>(lotto);
			// 로또 번호를 정렬해서 출력하기
			Collections.sort(lottoNumber);

			System.out.println("로또번호  " + i + "  번째는  : " + lottoNumber);
		}
		System.out.println();
		System.out.println("받은 금액은 : " + money + " 원 이고, 거스름돈은 : " + (money % 1000));
	}

}
