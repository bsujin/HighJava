package kr.or.ddit.basic.Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kr.or.ddit.basic.ScanUtill;

public class Hotel {
	
	private Map<Integer,Room> reservation;
	private List<Map<Integer,Room>> room;
	List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
	
	private Hotel(){
	reservation = new HashMap<>();
	room = new ArrayList<Map<Integer,Room>>();
	
	for (int i = 201; i <= 209; i++) {
		reservation.put(i, new Room(i, "싱글룸", " - ")); 
	}
	
	for (int j = 301; j <= 309; j++) {
		reservation.put(j, new Room(j, "더블룸", " - "));
	}
	
	for(int k = 401; k <=409; k++) {
		reservation.put(k, new Room(k, "스위트룸", " - "));
	}
	
	
			
	}

	public static void main(String[] args) {
		new Hotel().start();

	}

	//프로그램을 시작하는 메서드 
	private void start() {
		System.out.println();
		System.out.println("*************************************\n");
		System.out.println("      호텔 문을 열었습니다. 어서오십시오 ");
		System.out.println("\n*************************************");
		System.out.println();
	
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			
			case 1 :
				checkIn();
				break;

			case 2 :
				checkOut();
				break;
				
			case 3 : 
				status();
				break;
				
			case 4 :
				System.out.println("******************************\n");
				System.out.println("         호텔문을 닫았습니다.");
				System.out.println("\n******************************");
//				System.exit(0);
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
		}
		
	}
	
	//2번 객실 체크아웃 하는 메서드 
	private void checkOut() {
	
	System.out.println("체크 아웃 할 방 번호를 입력하세요");
	System.out.print("방번호 입력 >>");
	int num = ScanUtill.nextInt();

	Room r = reservation.get(num);
	if(r.getCustomer().equals("-")) {
		System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
	return;
	}	
	System.out.println(num + "호 객실의 " + r.getCustomer() + "님 체크아웃을 완료하였습니다.");
	r.setCustomer(" - ");
		
	
	}

	//3번 객실 상태를 출력하는 메서드 
	private void status() {
		
	System.out.println("-------------------------------");
	System.out.println("          현재  객실  상태   ");
	System.out.println("-------------------------------");
	System.out.println("  방 번호	   방 종류          투숙객 이름  ");
	System.out.println("-------------------------------");
	
	//정렬 없이 출력
//	//Iterator 사용
//	Iterator<Integer>rooms = reservation.keySet().iterator();
//	while(rooms.hasNext()) {
//	 Integer roomsnum = rooms.next();	//키 값 찾기 
//	 Room r = reservation.get(roomsnum); //value값  구하기
//	 
	 
	
	
//	향상된  for문 사용 
//	for(Integer r : reservation.keySet()) {
//		System.out.println(reservation.get(r));
//	}
	
	
	
	//정렬 출력 1
		for(int i = 201; i<=209; i++ ) {
		 System.out.println(reservation.get(i));
		 }
		 for(int j = 301; j<=309; j++) {
			System.out.println(reservation.get(j));
		 }
		 for(int k = 401; k<409; k++) {
			 System.out.println(reservation.get(k));
		 }
		
	
	//정렬 출력 2 : list 
	
	
	System.out.println("-------------------------------");
	System.out.println();
	
		
		
	}

	//1번 체크인 하는 메서드 
	
	private void checkIn() {
		
		System.out.println("-----------------------------------");
		System.out.println("              체크인 작업 ");
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println(" * 201 ~ 209 : 싱글룸 ");
		System.out.println(" * 301 ~ 309 : 더블룸 ");
		System.out.println(" * 401 ~ 409 : 스위트룸");
		System.out.println();
		System.out.println("-----------------------------------");
		
		System.out.print(" 방 번호 입력 >>");
		int num = ScanUtill.nextInt();
		Room r = reservation.get(num);
		
		
		if(!reservation.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		if(r.getCustomer().equals(" - ")){
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름입력 >>");
		String name = ScanUtill.nextLine();
		r.setCustomer(name);
		System.out.println(name + "님 체크인이 완료 되었습니다.");
		}else{
			System.out.println("현재" + num+ " 은 예약이 되어 있습니다.");
		}
	}

	
	//업무 선택 창
	private int displayMenu() {
		System.out.println("-----------------------------------");
		System.out.println("   어떤 업무를 하시겠습니까? ");
		System.out.println();
		System.out.println(" 1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.print(" 선택>> ");
		
		int num = ScanUtill.nextInt();
		return num;
	}

}

class Room{
//	방번호(int), 방종류, 투숙객이름
	private int roomNum;
	private String roomName;
	private String customer;
	
	
	@Override
	public String toString() {
		return  "  " + roomNum +" \t " +  roomName + "\t    " +  customer  ;
	}

	public Room(int roomNum, String roomName, String customer) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.customer = customer;
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	
	
	
	
}