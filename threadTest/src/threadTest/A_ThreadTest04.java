package threadTest;

/*
 	1 ~ 20억 까지의 합계를 구하는 프로그램을 
 	하나의 쓰레드가 단독으로 처리했을 때와 
 	여러개(4개로 나눔) 의 쓰레드가 협력해서 처리할 때의 처리시간을 비교해보자.
 	
 	join 과 sleep은 exception을 처리해야함
 	
 */
public class A_ThreadTest04 {

	public static void main(String[] args) {
		//단독으로 처리하는 쓰레드 만들기
		
		//객체 생성
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		//여럿이 협력해서 처리하는 쓰레드 생성 -> 배열 형식
		SumThread[] sums = new SumThread[] {
			new SumThread(1L, 500_000_000L),	
			new SumThread(500_000_001L, 1_000_000_000L),	
			new SumThread(1_000_000_000L, 1_500_000_000L),	
			new SumThread(1_500_000_000L, 2_000_000_000L)
		};
		
		//단독으로 처리하기
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리했을 때 처리시간 : " + (endTime-startTime));
		System.out.println();
		
		
		//여러개의 쓰레드가 협력해서 처리하는 경우
		startTime =  System.currentTimeMillis();
		
		//배열의 갯수만큼 반복
		for (int i = 0; i < sums.length; i++) {
			sums[i].start();
			
		}
		//4개의 쓰레드가 다 끝날때 까지 기다리기 
		for (SumThread th : sums) {
			try {
				th.join();
			} catch (InterruptedException e) {
				//Interupt : 특정 스레드에게 작업을 멈춰달라고 요청하는 상태
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력해서 처리 했을 때 처리 시간 : " + (endTime-startTime));
		
		//똑같은 일을 할  경우 나눠서 처리하는 것이 더 빠르다.
		
		
	}

}


//클래스는 하나만 만들어서 여기서 다 처리하도록 만들기 

class SumThread extends Thread{
	
	// 합계를 구할 영역의 시작 값과 종료값을 저장하는 변수 선언
	private long startNum;
	private long endNum;
	
	//생성자 만들기
	public SumThread(long startNum, long endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}

	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = startNum; i<=endNum; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	
	}
	
}
