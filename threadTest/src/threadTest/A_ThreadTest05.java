package threadTest;

import javax.swing.JOptionPane;

public class A_ThreadTest05 {

	//입력을 받을 때 scanner 대신 swing을 짤 수 있는 명령어 
	//JOptionPane.showInputDialog
	
	public static void main(String[] args) {
		
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력한 값 : " + str); 	//입력한 값(값을 넣고 확인 또는 enter) 이 변수에 저장됨
												//입력을 취소(취소를 누르거나 esc)하면 null값이 나옴
		
		//입력을 기다리는 시간동안 카운트하는 작업 -> 동시실행 (쓰레드)
		
		//싱글 쓰레드일 경우 입력을 한 다음 카운트다운을 함 -> 순서를 바꾸면 카운트 다운하고 입력 : 싱글쓰레드로 이러한 것을 만들기가 어려움 ==> 멀티쓰레드 사용 
		
		//1초동안 한번씩 출력하도록 하기 
		for(int i = 10; i>=1; i--) {
			System.out.println(i);	
			try {
				//1초동안 잠시 멈춘다 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		
	}

}
