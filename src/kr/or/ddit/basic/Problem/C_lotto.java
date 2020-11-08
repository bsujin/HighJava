package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import kr.or.ddit.basic.ScanUtill;

public class C_lotto {
	/*
	 * 문제) 로또를 구매하는 프로그램 작성하기
	 * 
	 * 사용자는 로또를 구매할 때 구매할 금액을 입력하고 입력한 금액에 맞게 로또번호를 출력한다. (단, 로또 한장의 금액은 1000원이며 최대
	 * 100장까지만 구입할 수 있고, 거스름돈도 계산하여 출력한다.)
	 */
	int money = 0;
	List<Integer> Lotto = new ArrayList<>();

	public static void main(String[] args) {
		main();
	}
	private static void main() {
		C_lotto lotto = new C_lotto();

		while (true) {
			System.out.println("\n==============================\n");
			System.out.println("\tLotto 프로그램");
			System.out.println("\n----------------------------\n");
			System.out.println("\t1.Lotto 구입");
			System.out.println("\t2.프로그램 종료");
			System.out.println("\n===============================\n");
			System.out.println("번호 입력>");
			int input = ScanUtill.nextInt();
			switch (input) {
			case 1:
				lotto.start();
				break;

			case 2:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("잘못 누르셨습니다. 다시입력해주세요.");
				break;
			}

		}
	}

	private void start() {

		System.out.println("\t로또 구입 ");
		System.out.println();
		System.out.println("로또 한개당 1000원 입니다.");
		System.out.print("금액을  입력해주세요>");
		money = ScanUtill.nextInt();
		if (money < 1000) {
			System.out.println();
			System.out.println("입력금액이 너무 적습니다.");
			System.out.println("로또 구입 실패!!!!!");
			main();
		} else if (money >= 101000) {
			System.out.println();
			System.out.println("입력금액이 너무 많습니다.");
			System.out.println("로또 구입 실패!!!!!");
			main();
		} else
			buy();

	}

	private void buy() {
		int change = money % 1000;
		HashSet<Integer> num = new HashSet<>();
		// int buyLotto = 3000 / 1000;
		int buyLotto = money / 1000;
		for (int i = 0; i < buyLotto; i++) {
			num = new HashSet<>();
			// Lotto.clear();
			
			//1~6까지의 로또 번호 추첨 
			while (num.size() < 6) {
				num.add((int) (Math.random() * 45) + 1);
			}
			
			// System.out.println(num);
			Lotto = new ArrayList<>(num);
			Collections.sort(Lotto);
			System.out.print("\n" + (i + 1) + "번째 로또번호 : ");

			for (int a : Lotto) {
				System.out.print(a + " ");
			}
			// Lotto.clear();

		}
		System.out.println();
		System.out.println("구매 완료!!!!");
		System.out.println("받은 금액은 : " + money  +" 원,"+ "거스름돈은 : " + change + " 원 입니다.");

	}
}	
	

