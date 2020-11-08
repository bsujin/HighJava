package threadTest;

/*
  	wait(), notify() 메서드를 이용한 예제
 	( 두 쓰레드가 번갈아 한번씩 실행하는 예제 )
 	
 	 - wait(), notify(), notifyAll() 메서드는 동기화 영역에서만 사용 가능하다.
 	 
 */

public class D_ThreadTest19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkObject workObj = new WorkObject();

		ThreadA tha = new ThreadA(workObj);
		ThreadB thb = new ThreadB(workObj);

		tha.start();
		thb.start();	//프로그램이 안 끝난 상태
	}

}

// 공통으로 사용할 객체
class WorkObject {

	public synchronized void testMethod1() {
		System.out.println("testMethod1() 메서드 실행 중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception

		}
	}

	public synchronized void testMethod2() {
		System.out.println("testMethod2() 메서드에서 작업 실행 중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception

		}
	}
}

// WorkObject의 testMethod1() 메서드만 실행하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.testMethod1();
		}
		// 마지막에  wait상태를 깨워준다.
				synchronized (workObj) {
					workObj.notify();
				}

	}
}

//WorkObject의 testMethod() 메서드만 실행하는 쓰레드
class ThreadB extends Thread {
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.testMethod2();
		}
		
		//이게 생기기 전까지는 실행이 멈추지 않음
		// 마지막에  wait상태를 깨워준다.
		synchronized (workObj) {
			workObj.notify();
		}

	}

}
