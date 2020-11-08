package threadTest;

//yield()메서드 연습 : 양보한다는 개념 

public class B_ThreadTest11 {

	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번 쓰레드");
		YieldThread th2 = new YieldThread("2번 쓰레드");

		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("===================================================");
		//=가 출력 된다음 WORK-false : 양보가 계속 실행 -1번이 양보, 2번이 계속 작업
		
		th1.work = false;
		//처음상태
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		//&가 출력 된 다음 work = true : 1번 작업중으로 바뀜
		
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		//값이 바뀌면 stop => 반복문 종료 
		th1.stop = true;
		th2.stop = true;

	}
}

//yield()메서드 연습용 쓰레드 
class YieldThread extends Thread{	
		
	public boolean stop = false;	// 쓰레드 종료 여부를 나타내는 값을 저장하는 변수 선언
	public boolean work = true;		// 작업을 처리하는 여부를 나타내는 값을 저장하는 변수 선언
	
	//생성자
	YieldThread(String name) {
		super(name);	//쓰레드의 이름을 설정한다.(이름을 저장하는 생성자)
		}
	
	@Override
	public void run() {
		
		while (!stop) {				//stop이 true가 되면 반복문이 종료된다.
			if(work) {
				
				//getName()메서드 ==> 현재 쓰레드의 name값을 반환한다.
				System.out.println(getName() + "작업중....");
				
			}else {
				System.out.println(getName() + "양보....");
				Thread.yield();
			}
			
		}
		super.run();
	}
	
}