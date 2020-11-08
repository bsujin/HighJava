package kr.or.ddit.basic.Problem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class D_PhoneBookTest_sem {
	
	private Map<String,Phones> phoneBookMap;
	private Scanner scan;
	
	//전화번호 정보가 저장될 때 파일명 설정
	private String fileName = "D:/D_Other/phoneData.dat";
	
	//데이터가 변경되었는지 여부를 나타내는 변수선언 ==> 데이터가 변경되면 true가 된다.
	//현재경우 (추가 삭제)만 하는 경우 말고 그 외에 여러 사항이 있는 경우에는 boolean 쓰면 안됨 
	private boolean dataChange;

	
	// 생성자
	public D_PhoneBookTest_sem() {
//		phoneBookMap = new HashMap<>();
		phoneBookMap = load();	// 파일 내용을 읽어와 map에 저장한다. (반환값을 저장) 

		if(phoneBookMap == null) {	//저장파일이 없거나 하면 
			phoneBookMap = new HashMap<>();
		}
		scan = new Scanner(System.in);
	}		
	
	public static void main(String[] args) {
		new D_PhoneBookTest_sem().phoneBookStart();
	}
	//프로그램을 시작하는 메서드 
	private void phoneBookStart() {
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println("\t전화 번호 관리 프로그램 ");
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1:	//등록
				insert();
				break;
				
			case 2 : //수정
				update();
				break;
				

			case 3 : //삭제
				delete();
				break;
				

			case 4 : //검색
				search();
				break;
				

			case 5 : //전체출력
				displayAll();
				break;
				
			case 6 : //저장
				save();
				break;

			case 0:	//종료
				if(dataChange==true) {
					System.out.println("변경된 내용을 저장합니다.");
					save();
				}
				System.out.println("프그램을 종료합니다.");
				return;
//				break;

			default: System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
				break;
			}
		}
		
	}
	
	//파일에 저장된 전화번호 정보를 읽어오는 메서드
	public HashMap<String, Phones> load(){
		
		//저장된 데이터를 읽어다가 맵으로바꿈
		HashMap<String, Phones> pMap = null; 	//읽어온 데이터가 저장될 변수
		
		File file = new File(fileName);
		
		//저장된 파일이 없으면 null값을 반환 
		if(!file.exists()) {
			return null;
		}
		
		//저장된 파일이 있으면 처리되는 곳
		ObjectInputStream ois = null;
		
		try {
			
			//객체 생성 
			ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(fileName)));
			
			//읽어와서 map으로 저장해주기 위해 형변환을 해준다.
			pMap = (HashMap<String, Phones>) ois.readObject();
			
			return pMap;	//반환해주기
			
		} catch (IOException e) {
			return null;
			
		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
			return null;
		}finally {
			if(ois !=null) try { ois.close(); } catch (Exception e) { }
		}
		
	}
	
	
	//전화번호 정보를 파일에 저장하는 메서드  
	//변경사항이 있으면 종료할때 자동으로 저장 됨 -> true로 바꿔주기 
	
	private void save() {
		ObjectOutputStream oos = null;
		try {			
			//객체를 출력하기 위한 출력용 스트림 객체 생성 
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName) ) );
					
			
			
			//Map 객체를 파일로 저장한다.
			oos.writeObject(phoneBookMap);
			
			System.out.println("저장이 완료되었습니다.");
			dataChange = true; //저장이 완료되면 현재 가지고 있는 데이터와 파일이 같다라는 뜻 (끝날때 중복저장을 방지)
			
		} catch (IOException e) {
			
		}finally {
			
			//사용했던 스트림 객체 닫기
			if(oos!=null) try{ 	oos.close(); } catch (IOException e) { }
			
			}
		
			}
	
				
	

		//전화번호를 검색하는 메서드 
		private void search() {
		System.out.println();
		System.out.println("검색 할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >>");
		String name = scan.next();
		
		//등록 된 전화번호 정보가 있는지 검사 
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "의 전화번호 정보가 없습니다.");
			return;
		}
		
		// 검색한 데이터가 있으면 해당 key값에 맞는 value값을 구한다.
		Phones p = phoneBookMap.get(name);
		System.out.println();
		System.out.println(name + " 의 전화번호 정보");
		System.out.println("==========================");
		System.out.println();
		System.out.println("이름  : " + p.getName());
		System.out.println("전화번호 : " + p.getTel());
		System.out.println("주소 : " + p.getAddr());
		System.out.println();
		System.out.println("==========================");
		
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.println("이름>>");
		String name = scan.next();
		
		// 삭제할 데이터 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "의 전화번호 정보가 없습니다.");
			System.out.println("삭제 작업 불가 !!!");
			return;
		}
		phoneBookMap.remove(name);
		System.out.println(name + "의 전화번호 정보를 삭제했습니다.");
		
		
	}

	
	//전화번호를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.print("이름  >> ");
		String name = scan.next();
		
		// 수정할 데이터가 있는지 검사
		//수정할 데이터가 없으면 등록이 안된 데이터
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "의 전화번호 정보가 없습니다.");
			System.out.println("수정 작업 불가 !!!");
			return;
		}
		
		//수정할 데이터가 있을때, 수정할 데이터 입력받기 
		System.out.print("새로운 전화번호 >>");
		String newTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 주소 >>");
		String newAddr = scan.nextLine();
		
		//입력한 데이터를 가지고 작업하는 방법
		//1. 콘솔 : 같은 키 값에 새로운 전화번호 정보를 저장 ==> 수정작업 
//		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
	
		//2. phone객체를 가져오기
		Phones p = phoneBookMap.get(name);	//키 값을 이용해서 value 값을 구한다. (value값을 p 에 저장)
		p.setTel(newTel);		// 구해온 Phone객체의 각각의 데이터를 변경한다. 
		p.setAddr(newAddr);		
		
		System.out.println(name + " 의 전화번호 정보를 변경하였습니다. ");
		
	
	}

	
	//Map에 저장된 전체 전화번호 정보를 출력하는 메서드 
	private void displayAll() {
		
	System.out.println();
	System.out.println("저장된 전화번호 목록 ");	
	System.out.println("----------------------------------------");
	System.out.println("    번호         이름             전화번호                 주소        ");
	System.out.println("----------------------------------------");
		
	if(phoneBookMap.size()==0) {
		System.out.println(" 등록된 데이터가 하나도 없습니다. ");
	} else { 
		int cnt = 0;	//번호를 나타내는 변수
		
		//Iterator사용, Iterator는 key값을 기준
		Iterator<String> phoneIt = phoneBookMap.keySet().iterator();
		
		while(phoneIt.hasNext()){
			cnt++;
			String name = phoneIt.next();	// 키값(등록된 사람이름 ) 찾기
			Phones p = phoneBookMap.get(name); ////value값 (phone 객체) 구하기 (객체의 값을 p에 저장)
			System.out.println("   " + cnt + " " + p.getName() + " " + p.getTel() + "  " + p.getAddr());
						
		}//while문 종료
				
	} //else문 종료
	
	 System.out.println("-------------------------------------------");
	 System.out.println(" 출력 작업 종료...");
	}

	
	//새로운 전화번호를 등록하는 메서드
	//key값이 같으면 안된다.
	private void insert() {
		
		System.out.println();
		System.out.println(" 새로 등록 할  전화번호 정보를 입력하세요.");
		
		System.out.print(" 이름 >>");
		String name = scan.next(); 	//next 띄어쓰기 없이 입력받을때
		
		// 이미 등록된 사람인지 검사하기
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + " 는 이미 등록된 사람입니다. ");
			return;  //실행되지 않게 메서드 종료 -> 호출한곳으로 돌아감
		}
		
		
		
		System.out.print("전화번호 >>");
		String tel = scan.next();
		
		//입력 버퍼 비우기
		scan.nextLine();
		
		System.out.print("주소>>");
		String addr = scan.nextLine();
		
		
		/*
		 nextLine으로 주소만 바꿀 경우 입력이 되지않고 넘어가는 현상이 생김 : scanner 메소드의 특징
			-Scanner의 입력받는 메서드의 특징
			1. next(), nextInt(), nextDouble()...
			 	==> 데이터를 사이띄기, Tap키, Enter키 값을 구분한다.
			 	ex. 가나다 마바사 / 가나다 		마바사/ 가나다 \n 마바사 => 데이터를 2개로 입력함
			 	변수 1 = scan.next();
			 	변수 2  = scan.next();
			 	
			 	
			입력 -> 임시기억장치에 저장 (buffer) : 입출력 buffer 
			* buffer의 역할 : cpu의 속도(cpu는 1초의 백만가지의 일 처리)는 빠른데, 입출력 장치의 속도는 cpu보다 엄청 느림 
			* buffer : 장치의 속도차이가 많이 나는곳에 존재함  
			* cpu는 buffer에 명령을 내림 -> buffer가 입력 신호를 받아서 처리함 -> buffer의  기억장치, 메모리의 영역이 가득 차면 한번에 보냄-> 효율이 높아짐 
			* buffer의 값을 scanner명령어가 읽어감  
			* buffer의 특징 : 
			*
			
		*/
		
//		//방법 1
//		Phone p = new Phone(name,tel,addr);
//		phoneBookMap.put(name, new Phone(p));
		
		//방법2
		phoneBookMap.put(name, new Phones(name, tel, addr));
		
		System.out.println(name + " 는 등록 완료!!!");
		
	}

	
	//메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("     다음 메뉴를 선택하세요 ");
		System.out.println();
		System.out.println(" 1. 전화번호 등록 ");
		System.out.println(" 2. 전화번호 수정 ");
		System.out.println(" 3. 전화번호 삭제 ");
		System.out.println(" 4. 전화번호 검색 ");
		System.out.println(" 5. 전화번호 전체 출력 ");
		System.out.println(" 6. 전화번호 저장 ");
		System.out.println(" 0. 프로그램 종료 ");
		System.out.println("------------------------");
		System.out.println();
		
		System.out.println(" 번호 입력 >> ");
		int num = scan.nextInt();
		return num;
		
	}
	
	
}


//하나의 전화번호 정보(이름, 주소, 전화번호)를 멤버로 갖는 phone클래스
class Phones implements Serializable{
	
	private static final long serialVersionUID = 2250276149440021699L;

	private String name;
	private String tel;
	private String addr;
	

	public Phones(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
