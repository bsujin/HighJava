package threadTest;

import javax.swing.JOptionPane;

/*
 	문제) 
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 		- 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 		- 사용자는 showInputDialog() 메서드를 이용해서 입력 받는다.
 		
 		- 입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 		- 5초 안에 입력이 없으면 게임에 진것으로 처리하고 끝낸다.
 		
 		- 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 
 	
 	5초안에 입력이 완료 되었을 때 결과예시 )
		 	-- 결과 --
		 	컴퓨터 : 가위
		 	사용자 : 바위
		 	결   과 :  당신이 이겼습니다.
		 	
		 	이겼습니다, 졌습니다, 비겼습니다. 
 
 	5초안에 입력이 없었을 때 결과 예시 ) 
 		시간이 초과되어 당신이 졌습니다.
 		
 */

public class B_ThreadTest07 {

	public static void main(String[] args) {
		Thread t1 = new InsertData();
		Thread t2 = new Count();
		
		
		t1.start();
		t2.start();

	}

}

class InsertData extends Thread {

	public static boolean check;

	@Override
	public void run() {
		
		//1 가위, 2 바위, 3 보
		
		
		int computer = ((int) (Math.random() * 3)+ 1);
		//컴퓨터의 숫자를 문자로 바꿔주기 
	


		
		String input = JOptionPane.showInputDialog("가위 ,바위,보를  입력하세요");
		check = true;
		
		//가위바위보를 숫자로 바꿔주기 
		int u;
		if(input.equals("가위")) {
			u=1;
		}else if(input.equals("바위")) {
			u=2;
		}else {
			u=3;
		}
		
		System.out.print("컴퓨터 : " );
		switch (computer) {
		case 1:
			System.out.println("가위");
			break;
		case 2:
			System.out.println("바위");
			break;
		case 3:
			System.out.println("보");
			break;

		}
		System.out.println("사용자 : " + input);
		
		//비교해주기 
		if (computer == u) {
			System.out.println("비겼습니다.");
		}
		else if(computer==1&&u==2||computer==2&&u==3&&computer==3&&u==1) {
			System.out.println("당신이 이겼습니다 ");
		}else {
			System.out.println("당신이 졌습니다.");
		}
		
	
//		System.out.println("사용자 : " + input);

	}
}

class Count extends Thread {

	@Override
	public void run() {

		for (int i = 10; i >= 1; i--) {
			if (InsertData.check == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		return;
	}
}
