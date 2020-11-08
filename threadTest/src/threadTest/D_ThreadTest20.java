package threadTest;

//쓰레드 2개 중 하나는 데이터를 공급만 하는 역할, 하나는 공급된 데이터를 사용만 하는 역할

public class D_ThreadTest20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBox  box= new DataBox();
		ProducerThread th1 = new ProducerThread(box);
		ConsumerThread th2 = new ConsumerThread(box);
		
		th1.start();
		th2.start();
	
	}

}

// 데이터를 공통으로 관리하는 클래스

class DataBox {
	private String data;

	// 데이터를 가져가는 메서드
	
	/*
	 * 처리 과정 ==> data변수의 값이 null이면 data,변수에 문자열이 채워질 때 까지 기다리고, data변수에 값이 있으면 해당
	 * 문자열을 반환한다. data 변수의 값을 반환한 후에는 data변수의 값을 null로 만든다.
	 */
	public synchronized String getData() {
		if (data == null) { // data가 null이면 기다리기
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		String returnData = data;
		System.out.println("쓰레드가 읽은 데이터 : " + returnData);
		data = null;

		// 상대편을 꺠워주기
		notify();
		return returnData;

	}

	
	// 데이터를 넣어주는 메서드
	/*
	 * 처리과정 ==> data변수의 값이 있으면 data변수의 값이 null이 될 때 까지 기다린다. data변수의 값이 null이 되면
	 * data변수에 새로운 값으로 저장한다.
	 * 
	 */
	public synchronized void setData(String data) {
		if (this.data != null) { // data가 null일 때 깨워줌
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		this.data = data;
		System.out.println("Thread에서 새로 저장한 데이터 : " + data);

		notify();

	}

}

//데이터를 넣어주는 쓰레드
class ProducerThread extends Thread{
	
	private DataBox box;

	//생성자
	public ProducerThread(DataBox box) {
		super();
		this.box = box;
	}
	
	@Override
	public void run() {
	for(int i =1; i<=5; i++) {
		box.setData("공급 데이터 :" + i);
	}
	}
}



//데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread{
	private DataBox box;

	public ConsumerThread(DataBox box) {
		super();
		this.box = box;
	}
	

	@Override
	public void run() {
	for(int i =1; i<=5; i++) {
		String data = box.getData();
	}
	}
	

	
}