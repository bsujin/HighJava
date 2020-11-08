package genericTest;


public class A_ArgsTest {
	
	/*
	 
	 	가변형 인수 ==> 메서드의 매개변수에 주어지는 인수의 개수가 실행 될 때 마다 다를 때 사용한다.
	 	(배열도 비슷한 역할을 하지만 불편, 가변형 인수를 사용)
	 	
	 	 - 가변형 인수는 메서드 내부에서는 배열로 처리한다.
	 	 - 가변형 인수는 한가지 자료형만 사용할 수 있다.
	 	 - 
	  
	 */
	
	
	
	

	public static void main(String[] args) {
	//호출과 실행하는 영역이 다름 : 호출하는 쪽에 있는 데이터를 메소드에 넘겨주고싶을때 매개변수를 줌 
	//외부에서 필요한 데이터를 매개변수로 처리, 스캐너로 입력받아서 처리..등 처리하는 방법은 설계자 마음대로
		
		//매개변수
//		//변수에 담아서 호출 
//		int k = 100;
//		test.test1(k); 
//		
//		//직접 값을 담아서 호출 
//		test.test1(300);
		
		
		
	A_ArgsTest test = new A_ArgsTest();//클래스 객체 생성
	
		System.out.println("배열을 사용할 때 ");
		int [] nums = {100,200,300};
		System.out.println(test.sumData(nums));	//nums : 인수값
		
		
		//직접 값을 넣고 싶을때 -> 배열일 경우 초기화를 다른 방법으로 써줘야 한다.
		int[] nums2 = new int[] {100,200,300};
		System.out.println(test.sumData(new int[] { 1,2,3,4,5}));
		
		System.out.println();
		System.out.println("가변형 변수를 사용할 때");
		System.out.println(test.sumArgs(100,200,300));
		System.out.println(test.sumArgs(1,2,3,4,5));
		
		System.out.println();
		System.out.println(test.sumArgs2("이순신", 80,70,90,100));
		
	}
	
	public void test1(int a) {
		
		
		
	}
	
	//collection 은 배열이 불편해서 만든것 
	
	//매개변수들의 합을 계산해서 반환하는 메서드  
	//매개변수 정할 때, 데이터의 개수는 호출할 때 마다 다를 수 있다. -> 배열을 이용한 메서드 
	public int sumData(int[] data) {		//인스턴스 메서드
		//배열에 들어있는 데이터의 합계 구하기
		//1.합계가 저장될 변수 구하기
		//2.반복문 사용하여 배열 개수만큼 반복
		//3. 반복문 안에서 배열의 값을 하나씩 끄내기
		
		int sum =0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
//			sum += data[i];
		}		
		return sum;	//sum이 가지고 있는 데이터를 반환 
	}
	
	
	//매개변수들의 합을 계산해서 반환하는 메서드 ==> 가변형 인수를 이용한 메서드
	//int형 자료를 가변형으로 쓰고, 쓴 자료를  data(변수)에 저장
	
	public int sumArgs(int...data) {
		//이 메서드 안에서 변수 'int...data'는 'int[] data'와 같다. 즉, 배열과 같다.
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
//			sum += data[i];
		}		
		return sum;	//sum이 가지고 있는 데이터를 반환 
	}
	
	
	/*
	  		가변형 인수를 사용할 때 주의할 점 
	 * 가변형 인수와 일반 인수를 같이 사용할 경우에는 가변형 인수를 뒤쪽에 배치한다.
	   						(일반인수, 가변형인수)
	   	==> 배치 이유  : 특히 타입이 다를 경우 가변형에서 몇개의 데이터를 넣을지 컴퓨터가 인식하지 못한다. 
	   		ex.(int name, int k, int b, int...data)
	   	
	 * 가변형 변수는 한가지만 사용 가능, 여러개는 사용할 수 없다. ex.(String name, int...data, float...ttt)
	 */

	private String sumArgs2(String name, int...data) { 
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
//			sum += data[i];
		}		
		return name + "씨의 합계 : " + sum; 
	}
	
}
