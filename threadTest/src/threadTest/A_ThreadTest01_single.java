package threadTest;

public class A_ThreadTest01_single {

	//싱글 쓰레드
	
	public static void main(String[] args) {
		/*스레드에 대한 개념,특징 
		 - 스레드 각각 마다 기능(매서드)을 호출해서 씀
		 - 메인메서드가 하나의 스레드역할을 함(현재까지 사용 : 싱글 스레드) 
		 */
		
		//*를 200개 찍는 기능
		 for(int i =1; i<=200; i++) {
			 System.out.print("*");
		 }
		
		 System.out.println();
		 System.out.println();

		 //$를 200개 찍는 기능 
		 for(int j=1; j<=200; j++) {
			 System.out.print("$");
		 }
		 
		 //순서  * => $ 로 처리된다. 
		 
	

	}

}
