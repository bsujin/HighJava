package threadTest;

public class C_ThreadTest16_synchronized {

	public static void main(String[] args) {
		ShareObject sobj = new ShareObject();
		
		TestThread th1 = new TestThread("1번 쓰레드",sobj);
		TestThread th2 = new TestThread("2번 쓰레드",sobj);
		
		th1.start();
		th2.start();
		
		//데이터의 일관성이 없게 출력이 된다.
		

	}
}

class TestThread extends Thread {
	private ShareObject sObj;

	// 생성자
	public TestThread(String name, ShareObject sObj) {
		super(name);	//쓰레드의 name 설정한다.
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}

}

// 공통으로 사용할 클래스 - 원하는 결과만 나오지 않는다

// 제어(락)하기 : synchronized

//쓰레드가 처음 -> 0 -> 10 0
class ShareObject {
	private int sum = 0;
	
	//방법 1 메서드에 동기화설정을 한다.
	public synchronized void add () {
		
		//방법 2 동기화 블럭으로 설정한다.
		synchronized (this) {	
			
	
		int n = sum;
		
		n += 10;
	
		sum = n;
	
		System.out.println(Thread.currentThread().getName() + " 합계  : " + sum);
		}	
	}
	
	
//	public void add() {
//		int n = sum;
//
//		n += 10;
//
//		sum = n;
//
//		System.out.println(Thread.currentThread().getName() + " 합계  : " + sum);
//	}
}
