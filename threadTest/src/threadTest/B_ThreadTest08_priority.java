package threadTest;

public class B_ThreadTest08_priority {

	public static void main(String[] args) {
		// 우선순위 테스트하기 : 동일할 때 

//		Thread th1 = new UpperThread();
//		Thread th2 = new LowerThread();
//			
//		System.out.println("th1의 우선순위 : " + th1.getPriority());
//		System.out.println("th2의 우선순위 : " + th2.getPriority());
//		
//		th1.start();
//		th2.start();
		
		//우선순위 바꾸기 

		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
			
		//우선 순위는 start()메서드를 호출하기 전에 변경하여야 한다.
		//코어가 많아서 숫자를 많이 주거나 적게 주어도 영향 동일, 싱글코어에서 유용함
		//==> 우선순위를 더 많이 분배하면 시간분배를 더 많이 받아 더 빨리 많이 실행됨
		
		th1.setPriority(10);
		th2.setPriority(1);
		
		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());
		
		th1.start();
		th2.start();
	}

}

//대문자를 출력하는 쓰레드
class UpperThread extends Thread{
	
	@Override
	public void run() {
		
		for(char c='A'; c<='Z'; c++) {
			System.out.println(c);
		}
		
		for(int i = 1; i<=2_000_000_000; i++) {}	//시간때우기 용 : 아무것도 안하는 반복문
		
	}
	
}

//소문자를 출력하는 쓰레드
class LowerThread extends Thread{
	@Override
	public void run() {
		for(char c='a'; c<='z'; c++) {
			System.out.println(c);
		}
		
		for(int i = 1; i<=2_000_000_000; i++) {}	//시간때우기 용 : 아무것도 안하는 반복문
		
		
	}
}
