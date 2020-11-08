package threadTest;

public class A_ThreadTest03 {
	// 쓰레드가 수행되는 시간을 체크해보자
	
	public static void main(String[] args) {
		
		//쓰레드 객체를 만들 때 (class 객체) 도 같이 생성 
		Thread th = new Thread(new MyRunner());
		
		
		//1970년 1월 1일 0시 0분 0초 (표준시간)로 부터 경과한 시간을 
		//밀리 세컨드 단위(1/1000초)로 반환한다.	==>실행되는 시점의 시간이 표준시간으로부터 얼마나 흘러갔나 경과한 시간을 반환 
		
		//시작하는 시점
		long startTime = System.currentTimeMillis();	//1
		th.start();	//2

		try {
			th.join();		//현재 실행증인 쓰레드에서 대상이 되는 쓰레드 (지금은 변수 th /  즉, 다른 쓰레드)가 끝날 때 까지 기다린다.
			
		} catch (InterruptedException e) {
			
			
		}
		
		//끝나는 시점
		long endTime = System.currentTimeMillis();	//3
		
		//경과시간 구하기 (끝나는 시점 - 시작하는 시점)
		System.out.println("실행시간 : " + (endTime - startTime));
		
		//실행시간이 먼저 나오고 합계가 나옴 -> 이유 : 시간출력은 main, start메서드->run 호출 -> 실행한 시간 출력만 하고 끝남
		// -> 예외 처리 해줘야함 join() 사용 하여 기다린다.
		
		
		
	}

}


class MyRunner implements Runnable{

	@Override
	public void run() {
		//합계 구하기 
		long sum = 0L;
		

		/*
		 * 자바에서는 숫자가 많을때 헷갈리면 _사용 
		 * 1_000_000_000L;
		 */
		
		for (long i = 1L; i<=1000000000L; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}
