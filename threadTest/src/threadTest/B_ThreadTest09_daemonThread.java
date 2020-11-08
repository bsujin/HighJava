package threadTest;

public class B_ThreadTest09_daemonThread {
	// 데몬 쓰레드 연습 ==> 자동 저장하는 쓰레드
	public static void main(String[] args) {
		
		//메인 메서드를 하나의 쓰레드로 사용 
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//반복되는 것을 제어 : 데몬쓰레드로 설정하기
		// 반드시 start()메서드 호출 전에 설정한다.
		autoSave.setDaemon(true);
		
		autoSave.start();
		
		try {
			
			for (int i = 0; i < 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("main 쓰레드 종료...");
	}

}

// 자동 저장하는 쓰레드 ==> 3초에 한번 씩 자동 저장하는 쓰레드
class AutoSaveThread extends Thread {

	// 작업 내용을 저장하는 메서드
	public void save() {
		System.out.println("작업 내용을 저장합니다...");
	}

	@Override
	public void run() {

		while (true) {	//메인 메서드가 종료 되어도 무한 반복됨
			try {
				Thread.sleep(3000);
				save();

			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

	}

}
