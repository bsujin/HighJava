package kr.or.ddit.basic.Problem;

import javax.swing.JOptionPane;

public class E_ThreadTest07_sem {
	
	public static boolean inputCheck;

	public static void main(String[] args) {	//메인 메서드를 하나의 쓰레드로 사용 

		GameTimer gt = new GameTimer();
		
		//난수를 이용해서 컴퓨터의 가위 바위 보를 정한다.
		
		//1-1. 가위바위보를 저장할 배열 만들기 
		String [] data = {"가위","바위","보"};
		
		//1-2. 난수 만들기 : 0~2사이의 난수 만들기 
		int index = (int)(Math.random() * 3);	
		String com = data[index];
		
		//2.카운트 다운 시작
		gt.start();
		
		//3.사용자로부터 가위 바위 보 입력 받기
		String man;
		do {
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		}while(!(man.equals("가위")||man.equals("바위")||man.equals("보")));	//전체 부정 - or : 잘못 입력 받았을 경우 
//		}while(!man.equals("가위")&&!man.equals("바위")&&!man.equals("보"));	//and로 했을 경우 
		
		inputCheck = true;
		
		//4. 결과를 판정하기
		String result = "";	//결과가 저장될 변수 선언
		
		if(man.equals(com)) {	//비기는 경우
			result = "비겼습니다.";
		}else if(man.equals("가위")&&com.equals("보")||man.equals("보")&&com.equals("가위")&&man.equals("바위")&&com.equals("가위")) {	//사람이 이기는 경우로 기준 
			result = "당신이 이겼습니다.";
		}else {
			result = "당신이 졌습니다.";
		}
		
		System.out.println();
		System.out.println("------- 결     과 -------");
		System.out.println(" 컴퓨터 : " + com);
		System.out.println(" 당  신  : " + man);
		System.out.println(" 결 과 : " + result);

	}
}

class GameTimer extends Thread {

	@Override
	
	public void run() {
		System.out.println("카운트 다운 시작....");
		
		 for(int i =5; i>=1;i--) {
			 if(E_ThreadTest07_sem.inputCheck==true) {	//입력여부검사
				 return;
			 }System.out.println(i+ "초 남았습니다.");
			 
			 try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		 }
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		System.exit(0);
	}
}
