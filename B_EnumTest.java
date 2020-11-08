package genericTest;

/*
  	enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
 			   ==> 클래스처럼 보이게 하는 상수
 			   ==> 열거형은 클래스처럼 독립된 java파일에 만들 수 있고,
 			   		하나의 java파일에 다른 클래스와 같이 만들 수 있고,
 			   		클래스 안에 내부클래스처럼 만들 수 있다.
  				
  				
  	- 열거형의 속성 및 메서드 
  	name() 	  ==> 열거형의 상수의 이름을 문자열로 반환한다.
  	ordinal() ==> 열거형 상수가 정의된 순서값(일종의 index값)을 반환한다. (0부터 시작) -> 상수가 만들어진 순서에 따라 인덱스가 만들어 진다. 
  	valueOf("열거형 상수명") ==> 지정된 열거형에서 '열거형상수명'과 일치하는 상수를 반환한다.
  	열거형 이름.상수명 ==> valueOf("상수명")와 같다.
  	
  	 
  	 - 열거형 선언하기 
  	 방법 1) 
  	 	enum 열거형이름{ 상수명1, 상수명2, .....	}
  	
  	 	
  	방법 2)
  		상수에 특별한 값을 처리하는 방법 
  		
  		enum 열거형이름{ 
  			상수명1(값들...),   -> 상수들을 선언할때 , 사용 끝에는 ;  
  			상수명2(값들...),
  			..
  			상수명n(값들...);
  		
 		//'값들'이 저장될 변수들을 선언한다. (private로 선언)
  			 private 자료형이름  변수명;
  			 ...
  			  
  		}
  		
  		// 열거형의 생성자를 만든다.
  		// 열거형의 생성자는 '열거형 상수'에 '값들'을 셋팅하는 역할을 수행한다.
  		// 열거형의 생성자는 묵시적으로 private이다. (= 자동으로 private)

  		//'변수명'은 '값들'과 개수가 같고, 각각의 '값들'과 자료형이 맞아야한다.
  		private 열거형이름 (자료형, 변수명, ....){
  			위에 선언된 변수들의 초기화 작업...
  			}
  			
  		// 구성된 '값들'을 외부에서 불러올 수 있는 getter메서드를 만든다.
  		 	(위에 선언된 변수들의 getter를 만든다.)
  		 
  		}
  	 
 */

public class B_EnumTest {

	// 상수 : 변수(데이터가 바뀔 수 있음)와 대비되는 말
	// 상수를 일종의 클래스처럼 쓰자하고 만든것 : 열거형

	public enum Color {
		RED, GREEN, BLUE
	} // 열거형선언

	public enum Num {
		ONE, TWO, THREE
	}

	public enum Season {
		봄(3, "5월"), // 상수명(값들...)형식의 선언
		여름(6, "8월"), 가을(9, "11월"), 겨울(12, "2월");

		// 값들이 저장될 변수선언
		private int startMonth; // (3)
		private String endMonth; // ("5월)

		// 생성자 - 초기화 해주기
		Season(int sMonth, String eMonth) { // private Season(int sMonth, String eMonth) 와 같다
			startMonth = sMonth;
			endMonth = eMonth;
		}

		// getter 메서드 작성 : 각각의 변수값을 외부에서 구하기 위해 만들어주기
		public int getStartMonth() {
			return startMonth;
		}

		public String getEndMonth() {
			return endMonth;
		}

	}

	public static void main(String[] args) {

		/*
		 * System.out.println("RED : " + ConstTest.RED);
		 * 
		 * System.out.println("Three : " + ConstTest.THREE);
		 * 
		 * if (ConstTest.RED == ConstTest.TWO) { System.out.println("~~~~~~~~~~"); }
		 * else { System.out.println("@@@@@@@@@@@@@@@@@@"); }
		 */

		// 열거형이 저장될 변수 만들기

		// 방법 1
		Color mycol = Color.valueOf("GREEN"); // 상수의 GREEN

		// 방법 2
		Color mycol2 = Color.GREEN;

		Num myNum = Num.ONE;
		System.out.println("mycol : " + mycol.name());
		System.out.println("myNum : " + myNum.name());
		System.out.println();

		// ordinal : 상수가 만들어지는 순서대로 나온 인덱스값
		System.out.println("mycol의 ordinal : " + mycol.ordinal());
		System.out.println("myNum의 ordinal : " + myNum.ordinal());

		// 서로 다른 종류의 열거형끼리의 비교는 불가하다.
		/*
		 * if(Color.BLUE == Num.THREE) { System.out.println("............"); }
		 */

		if (mycol == Color.RED) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		System.out.println();

		// switch문에 들어간 상수 : 컬러명 상수
		switch (mycol) {

		// case문 옆에 지정한 '상수명'은 '열거형.상수명'에서 '열거형'이름을 빼고 작성한다. (ex. color.red가 아니라 red만 )

		case RED:
			System.out.println("red");
			break;

		case BLUE:
			System.out.println("blue");
			break;

		case GREEN:
			System.out.println("green");
			break;

		}
		System.out.println("--------------------------------------");

		// season 열거형 사용
		// 방법 1
		// Season ss = Season.valueOf("봄");

		// 방법2
		Season ss = Season.가을;

		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("startMonth : " + ss.getStartMonth());
		System.out.println("endMonth : " + ss.getEndMonth());
		System.out.println();

		/*
		 * 열거형명.values() 열거형에 있는 모든 상수들을 배열로 가져온다.
		 */
		for (Season time : Season.values()) {
			System.out.println(time.name() + " ==> " + time.getStartMonth() + "월 부터 " + time.getEndMonth() + "까지");

			// 상수 이름 출력하기
			System.out.println("----------------상수-----------------------------");
			System.out.println(time + " ==> " + time.startMonth + "월 부터 " + time.endMonth + "까지");
			System.out.println("-------------------------------------------");
		}

			// ordinal 출력하기
			System.out.println();
			for (Color col : Color.values()) {
			System.out.println(col + " ===> " + col.ordinal());
		}
			
			// *열거형으로 만들어진 것을 사용할 때, 열거형의 의미와 가져오는 것을 이해해야함 

	}

}
