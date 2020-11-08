package threadTest;
/*
 	Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
 	이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어
 	나중에 실행되는 프로그램에 영향을 줄 수 있다.
 	그래서 stop() 메서드는 비추천으로 되어있다.
  
 */

public class C_ThreadTest14 {
	public static void main(String[] args) {
		
//		ThreadStopTest1 th1 = new ThreadStopTest1();
//		th1.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//
//		// th1.stop();
//		th1.setStop(true);
		
		
		
		//interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		th2.interrupt(); //끼어들기
		
		

	}
}

// 쓰레드를 멈추게 하는 연습용 쓰레드
class ThreadStopTest1 extends Thread {
	private boolean stop; // 쓰레드의 종료를 제어할 때 사용하는 변수 선언

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {

		while (!stop) {
			System.out.println("쓰레드 실행중");

		}
		System.out.println(" 자원 정리...");
		System.out.println(" 쓰레드 종료...");

	}
}




//interrupt() 메서드를 이용하여 쓰레드를 멈추게 하는 방법
//class ThreadStopTest2 extends Thread {


/*	
	방법1) interrupt()메서드와 sleep()메서드를 이용하는 방법
	쓰레드가 일시 정지 상태에서 interrupt()메서드가 호출하면 해당 쓰레드는 일시정지 상태에서 풀려나고 동시에 InterruptedException을 발생시킨다. 
*/

//@Override
//public void run() {
	
//	//방법 1) interrupt()메서드외 sleep() 메서드를 이용하는 방법 
//
//	try {
//
//		while (true) {
//			System.out.println("......실행중.......");
//			Thread.sleep(1);	//1이어도 쌓이다 보면 일처리할때 효율이 떨어 질 수 있다.
//			
//		}
//	} catch (Exception e) {
//
//	}
//	System.out.println(" 자원 정리...............");
//	System.out.println(" 쓰레드 종료...............");
//	
//}
//}

// interrupt() 메서드를 이용하여 쓰레드를 멈추게 하는 방법
class ThreadStopTest2 extends Thread {


	@Override
	public void run() {
				
		while(true) {
			System.out.println("Thread 실행중.....");
			
			//interrupt()메서드가 호출되었는지 검사한다.
			
			// 검사방법 1) 쓰레드의 인스턴스 메서드인 isInterrupted()메서드를 이용한다.
			// isInterrupted()메서드는 interrupt() 메서드가 호출되면  true를 반환한다.
			
			if(this.isInterrupted()) { 	//true라는 의미(this)
				break;	
			}
		
			
			
			//검사방법2) 쓰레드의 정적메서드인 interrupted()메서드 이용하기
			//interrupted()메서드 ==> interrupted()메서드가 호출되면  true를 반환한다.
			if(Thread.interrupted()) {		//true라는 의미(Thread.)
				break;
			}
			
		}
		
		System.out.println("자원정리..................");
		System.out.println("쓰레드 종료.................");
		
			
	}
}


	