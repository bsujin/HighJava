package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * 문제) 호텔 객실을 관리하는 프로그램을 작성하시오.

   조건1)  호텔 객식을 나타내는 Room클래스는 방번호(int), 방종류, 투숙객이름 필드로 구성되어 있고			     
           방번호와 방종류는 다음과 같다.
           - 201~209 : 싱글룸
           - 301~309 : 더블룸
           - 401~409 : 스위트룸
=> key 에 미리 저장 

   조건2) 전체 객실 관리는 Map을 이용한다.
          (Map의 key값은 방번호로 하고 value값은 Room의 인스턴스로 한다.)
          생성자에서는 방번호와 방종류를 초기화한다.

방번호 : 키 값, value으로저장 
생성자 : class 의 생성자 


실행예시)

*********************************************
       호텔문을 열었습니다. 어서오십시요.
*********************************************


-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
   체크인 작업
----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 101     <--- 입력

//없는 객실번호 입력시 
101호 객실은 존재하지 않습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
   체크인 작업
----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 201     <--- 입력
누구를 체크인 하시겠습니까?
이름 입력 >> 홍길동

체크인이 완료되었습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
   체크인 작업
----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 201     <--- 입력
201호 객실은 이미 손님이 있습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	3     <--- 입력

----------------------------------------------
		현재 객실 상태
----------------------------------------------
방 번호	 방 종류	 투숙객 이름
----------------------------------------------
201	 싱글룸 	홍길동	
202	 싱글룸 	  -	
203	 싱글룸 	  -	
204	 싱글룸 	  -	
205	 싱글룸 	  -	
206	 싱글룸 	  -	
207	 싱글룸 	  -	
208	 싱글룸 	  -	
209	 싱글룸 	  -	
301	 더블룸 	  -	
302	 더블룸 	  -	
303	 더블룸 	  -	
304	 더블룸 	  -	
305	 더블룸 	  -	
306	 더블룸 	  -	
307	 더블룸 	  -	
308	 더블룸 	  -	
309	 더블룸 	  -	
401	스위트룸	  -	
402	스위트룸	  -	
403	스위트룸	  -	
404	스위트룸	  -	
405	스위트룸	  -	
406	스위트룸	  -	
407	스위트룸	  -	
408	스위트룸	  -	
409	스위트룸	  -	
----------------------------------------------

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
   체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 101    <--- 입력
101호 객실은 존재하지 않습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
   체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 303    <--- 입력
303호 객실에는 체크인 한 사람이 없습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
   체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 201    <--- 입력
201호 객실의 홍길동님 체크아웃을 완료하였습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	3    <--- 입력


----------------------------------------------
		현재 객실 상태
----------------------------------------------
방 번호	 방 종류	 투숙객 이름
----------------------------------------------
201	 싱글룸 	  -	
202	 싱글룸 	  -	
203	 싱글룸 	  -	
204	 싱글룸 	  -	
205	 싱글룸 	  -	
206	 싱글룸 	  -	
207	 싱글룸 	  -	
208	 싱글룸 	  -	
209	 싱글룸 	  -	
301	 더블룸 	  -	
302	 더블룸 	  -	
303	 더블룸 	  -	
304	 더블룸 	  -	
305	 더블룸 	  -	
306	 더블룸 	  -	
307	 더블룸 	  -	
308	 더블룸 	  -	
309	 더블룸 	  -	
401	스위트룸	  -	
402	스위트룸	  -	
403	스위트룸	  -	
404	스위트룸	  -	
405	스위트룸	  -	
406	스위트룸	  -	
407	스위트룸	  -	
408	스위트룸	  -	
409	스위트룸	  -	
----------------------------------------------


-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	4    <--- 입력

*********************************************
       호텔문을 닫았습니다.
*********************************************
 */

public class D_DaedeokHotel {
	Map<Integer, Rooms> hotelMap;
	Scanner scan;

	// 생성자
	private D_DaedeokHotel() {
		hotelMap = new HashMap<Integer, Rooms>();
		scan = new Scanner(System.in);

		// 객실 초기화 -> 반복문 사용
		// 200부터 400까지 100씩 증가 하는것도 가능

		for (int i = 2; i <= 4; i++) {

			// 룸타입 변수 초기화
			String roomType = null;

			switch (i) {
			case 2:
				roomType = "싱글룸";
				break;
			case 3:
				roomType = "더블룸";
				break;
			case 4:
				roomType = "스위트룸 ";
				break;
			}
			for (int j = 1; j <= 9; j++) {
				// 룸 번호 만들기
				int roomNum = i * 100 + j;

				// 룸 객체 만들기 , 객실 초기화
				Rooms room = new Rooms(roomNum, roomType);
				hotelMap.put(roomNum, room);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new D_DaedeokHotel().hotelStart();
	}

	private void hotelStart() {
		System.out.println("***********************************************");
		System.out.println("            호텔 문을 열었습니다. 어서오십시요.");
		System.out.println("***********************************************");
		System.out.println();

		while (true) {
			int choice = displayMenu();

			switch (choice) {

			case 1: // 체크인
				checkIn();
				break;

			case 2: // 체크아웃
				checkOut();
				break;

			case 3: // 객실상태
				showRoom();
				break;

			case 4: // 업무종료
				System.out.println("*******************************************");
				System.out.println("                 호텔 문을  닫았습니다.");
				System.out.println("*******************************************");
				return;

			default:
				System.out.println(" 번호를 잘못 입력했습니다. 다시 선택하세요.");
				break;
			}

		}
	}

	// 객실 상태를 출력해주는 메서드
	private void showRoom() {

		// 방 번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣어서 정렬하여 사용한다.
		// ArrayList<Integer> roomNumList = new ArrayList<>();
		// //list에 넣을때 향상된 for문을 사용하여 add하기 (Map의 키값을 list에 추가하기)
		// for (int num : hotelMap.keySet()) {
		// roomNumList.add(num);
		// }
		//
		//
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());

		Collections.sort(roomNumList); // 방 번호를 오름차순으로 정렬하기

		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("  \t현재 객실 상태 ");
		System.out.println("------------------------------------");
		System.out.println("   방 번호 \t방 종류  \t     투숙객 이름 ");
		System.out.println("-------------------------------------");

		// List에서 방번호를 하나씩 꺼내와 Map에서 방번호에 해당하는 Room객체를 구해서 출력한다.
		for (int i = 0; i < roomNumList.size(); i++) {
			// 룸 객체 생성
			Rooms r = hotelMap.get(roomNumList.get(i));
			System.out.print(r.getRoomNum() + "\t" + r.getRoomType() + " \t ");

			// 그냥 출력되면 null로 출력되는 투숙객 이름을 -로 바꿔주기
			String name = " - ";
			if (r.getGuestName() != null) { // 방에 손님이 있으면 "-"로 바꿔주기
				name = r.getGuestName();
			}
			System.out.println(name);
		}
		System.out.println("-------------------------------------");
		System.out.println();

	}

	// 체크아웃을 처리하는 메서드
	private void checkOut() {
		System.out.println("------------------------------");
		System.out.println("           체크아웃  작업 ");
		System.out.println("------------------------------");
		System.out.println("  체크아웃 할 방 번호를 입력해주세요.");
		System.out.println(" 방 번호 입력 >> ");
		int roomNum = scan.nextInt();

		// 입력한 방번호가 있는지 검사 ( 키 값으로 입력한 방번호가 있는지 검사)
		if (!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다. ");
			return;
		}
		// 해당 객실에 손님이 없는지 검사
		if (hotelMap.get(roomNum).getGuestName() == null) {
			System.out.println(roomNum + "호 객실에는 체크아웃 할 손님이 없습니다.");
			return;
		}

		// 체크아웃 작업은 해당 객실의 guestName을 삭제 ==> null로 변경

		// 1. 현재손님 이름 구하기
		String name = hotelMap.get(roomNum).getGuestName();
		// 2. 손님 이름을 null로 변경
		hotelMap.get(roomNum).setGuestName(null);

		System.out.println(roomNum + "호 객실의 " + name + "님  체크아웃 되었습니다.");

	}

	// 체크인을 처리하는 메서드
	private void checkIn() {
		System.out.println("------------------------------");
		System.out.println("           체크인 작업 ");
		System.out.println("------------------------------");
		System.out.println(" * 201~209 : 싱글룸\r\n" + " * 301~309 : 더블룸\r\n" + " * 401~409 : 스위트룸");
		System.out.println("------------------------------");
		System.out.println(" 방 번호 입력 >>");
		int roomNum = scan.nextInt();

		// 입력한 방번호가 있는지 검사 ( 키 값으로 입력한 방번호가 있는지 검사)
		if (!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다. ");
			// return;
		}
		// 입력한 방이 예약이 되어있는지 검사
		else if (hotelMap.get(roomNum).getGuestName() != null) {
			System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
			// return; -> return 또는 else사용
		} else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("체크인 할  이름 >>");
			String name = scan.next();

			// 입력 받은 객실 번호에 맞게 투숙객 이름을 저장한다.
			// 기존에 저장되어있는 roomNum을 가져와서 입력 받은 이름을 저장한다
			hotelMap.get(roomNum).setGuestName(name);
			System.out.println(name + "님 " + roomNum + "호 객실에 체크인 되었습니다.");

		}

	}

	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		int num = 0;
		
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("      어떤  업무를 하시겠습니까 ?");
			System.out.println(" 1.체크인   2.체크아웃  3.객실상태  4.업무종료 ");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>");
		
			//문자가 입력 받았을때의 예외
			
			//try안에는 예외가 생기는 코드 입력 
			try {
				//입력받은것을 형변환 :숫자일 경우에는 문자로 -> 숫자로 형변환
				num = Integer.parseInt(scan.nextLine());
				break;
				
			//catch는 예외가 발생했을때 출력할 문장
			} catch (Exception e) {
				//break가 없으니 다시 반복문 실행 
				System.out.println("숫자만 입력하세요");
			}
		}
		return num;
	}

}

class Rooms {

	private int RoomNum;
	private String RoomType;
	private String guestName;

	public int getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Rooms(int roomNum, String roomType) {
		super();
		RoomNum = roomNum;
		RoomType = roomType;
	}

}
