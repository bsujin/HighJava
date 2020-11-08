package threadTest;

public class A_ThreadTest02 {

	// 멀티 쓰레드

	public static void main(String[] args) {
		// Thread를 작성해서 사용하는 방법

		/*
		 * 방법1
		 * 
		 * Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출해서 실행한다.
		 */

		// 쓰레드의 객체 생성
		MyThread1 th1 = new MyThread1();
		th1.start(); // start() 로 시작 -> run을 start()로 호출함
//		th1.run();

		/*
		 * 방법2
		 1. runnable 인터페이스를 구현한 class의 인스턴스를 생성한 후
		 2. 이 인스턴스를 Thread의 인스턴스를 생성할 때 생성자의 인수값으로 넘겨준다. 
		 3. 이 때 생성된 Thread의 인스턴스의 start()메서드를 호출해서 실행한다.
		 
		 */

		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start(); 	
		
		/*
		 * 방법 3 ==> 익명 구현체를 이용하는 방법
		
		인터페이스는 내부에 메서드만 선언되었기 때문에 객체를 생성할 수 없다.
		Runnable r3 = new Runnable();
		
		인터페이스가 선언해놓은 매서드를 정의해서 구현할 수 있다.-> 클래스 이름이 없어서 익명 구현체라고 한다. */ 
		
		Runnable r3 = new Runnable() {

			@Override
			public void run() {
				 for (int i = 0; i < 200; i++) {
					System.out.print("%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					
				}
				
			}
			
		}		
};

	Thread th3 = new Thread(r3);
	th3.start();
	
	System.out.println("main 메서드 끝....");	//보통 메인메서드가 출력 되고나서 실행되는데, 먼저 출력됨
	//싱글 쓰레드 : 메인메서드만 끝나면 끝남 
	//멀티쓰레드 프로그램 : 쓰레드가 여러개 작동, 모든 쓰레드가 다 끝나야 끝남

	}
}


// 방법 1

// 스레드를 상속해서 원하는 클래스 만들기 - run
class MyThread1 extends Thread {
	@Override
	public void run() {
		// 이 run() 메서드 안에 Thread가 처리할 내용을 기술한다.

		// 싱글 쓰레드의 *를 200개 찍는 기능가져와서 처리
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {

				// Thread.sleep(시간); ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				// '시간'은 밀리세컨드 단위를 사용한다.
				// 즉, 1000은 1초를 의미한다.
				Thread.sleep(100); // 100 = 1/10초 정도 멈춰라라는 의미

			} catch (InterruptedException e) {

			}
		}
	}
}

// 방법2

class MyThread2 implements Runnable {

	@Override
	public void run() {
		// 싱글 쓰레드의 $를 200개 찍는 기능
		for (int j = 1; j <= 200; j++) {
			System.out.print("$");
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {

			}
		}
	}
}

/* 방법이 2가지인 이유
 * 상속을 안받을때는 방법 1,2 둘다 상관이 없음 
 
 * 방법 1 : 상속 - 상속은 한가지만 가능 (단일상속)
 * 방법 2 : 다른 클래스를 상속받고, 쓰레드 기능을 추가 
 * 
 */


