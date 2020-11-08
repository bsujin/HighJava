package threadTest;

import javax.swing.JOptionPane;

public class A_ThreadTest06 {

	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();

	}

}





//데이터를 입력하는 쓰레드

//run + ctrl +space -> override메소드 생성
class DataInput extends Thread{
	
	//입력 여부를 확인하기 위한 변수 선언 ==> 쓰레드에서 공통으로 사용할 변수 
	public static boolean inputCheck;		//초기화를 안하면 기본적으로 false
	
	
	/*두개의 run이 실행됨 -> COUNT 는 계속 실행, 입력창은 멈춰있음*/ 
	
	@Override
	public void run() {
	 String str = JOptionPane.showInputDialog("아무거나 입력하세요");
	 
	 //입력이 완료된 시점 -> 완료가 된 다음 처리할 내용
	 inputCheck = true;
	  System.out.println("입력한 값 : " + str);
	}
	
}

//카운트 다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		
		for (int j = 10; j >=1; j--) {
			
			//검사 : inputCheck와 값이 같으면 => 입력이 완료되었는지 여부를 검사해서 완료되면 쓰레드를 종료한다.
			if(DataInput.inputCheck==true) {
				return;			//run()메서드가 종료되면 해당 쓰레드로 종료된다.
			}
			System.out.println(j);
			
		try {
			Thread.sleep(1000);	//1초동안 잠시 멈춘다.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}	
		}
		System.out.println("10초가 지났습니다.");
		System.exit(0);
	}
}
