package threadTest;

// 은행의 입출금을 쓰레드로 처리하는 예제
// 동기화 처리 예제 

public class C_ThreadTest17 {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금하는 메서드

	public void deposit(int money) {
		balance += money;
	}

	// 출금하는 메서드(출금 성공 : true, 출금 실패 : false 반환)
	// public boolean withdraw(int money) {

	// 방법2
	public synchronized boolean withdraw(int money) {

		// 방법 2 동기화블럭
		synchronized (this) {

			// 출금 가능 여부를 판단한다 : 잔액이 크거나 같아야 출금 가능
			if (balance >= money) {

				for (int i = 1; i <= 1000000000; i++) {
				} // 시간 제어용 : 다른쓰레드로 제어를 넘어가기 위해 아무것도 안하는 반복문

				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				return true;
			} else { // 출금실패
				return false;
			}
		}
	}

	public static void main(String[] args) {

		C_ThreadTest17 acount = new C_ThreadTest17();

		acount.setBalance(10000); // 잔액을 10000원으로 설정

		// 익명 구현체로 쓰레드 구현 : runnable 인터페이스 사용

		Runnable test = new Runnable() {

			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금하기
				System.out.println("쓰레드에서 result = " + result + " , balance = " + acount.getBalance());

			}
		};

		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();

		// 정상적으로는 출금이 한번만 일어나야한다.

	}

}
