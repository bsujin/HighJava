package threadTest;

//쓰레드의 상태를 출력하는 예제
public class B_ThreadTest10_state {

	public static void main(String[] args) {
		TargetThread t = new TargetThread();
		StatePrintThread th = new StatePrintThread(t);

		th.start();
	

		
	}

}


// 쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	
	@Override
	public void run() {
		for(long i=1L; i<=20_000_000_000L; i++) {	}	//시간 지연용
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	
		for(long i = 1L; i<=20_000_000_000L; i++) { } 	//시간 지연용
	}
}

//TargetThread의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	
	//위에서 만든 TargetThread가 저장될 변수 선언 
	private TargetThread target;
	
	//생성자
	public StatePrintThread(TargetThread target) {
		this.target = target;
		
	}
	
	@Override
	public void run() {
		//TargetThread의 상태를 검사해서 실행이 끝나면 같이 끝나도록 만들기
		while(true) {
			//TargetThread의 현재 상태 구하기(get사용) -> 열거형 상수로 반환
			Thread.State state = target.getState();
			System.out.println("TargetThread의 현재 상태값 : " + state);
		
			
			if(state==Thread.State.NEW) {	//쓰레드의  현재 상태가 new(아직 start 하기 전)라는 조건
				target.start();
			}
			
			if(state==Thread.State.TERMINATED) {	//쓰레드가 종료상태 라는 조건 
				break;
			}
		 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { 
				// TODO: handle exception
			}
		}
	}
	
}
