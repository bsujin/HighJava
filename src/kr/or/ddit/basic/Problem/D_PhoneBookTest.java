package kr.or.ddit.basic.Problem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
문제 ) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
 Map을 이용해서 전화번호 정보를 관리하는 프로그램을 작성하시오.
 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.

 (Map의 구조는 key값으로 '이름'을 사용하고, value값으로 'Phone클래스의 인스턴스'로 한다)

 - 삭제, 검색 기능은 '이름'을 입력받아 처리한다.
 
 -추가조건 ) 
 	1) 메뉴에 '6.,전화번호저장' 메뉴를 추가하고 전화번호를 저장하는 기능을 구현한다.
 	(저장파일명 : phoneData.dat)
 	2)  프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
 	3) 프로그램을 종료할 때 전화번호 데이터가 변경되거나 추가 또는 삭제되었으면
 		변경된 데이터를 저장한 후 종료되도록 한다.
 		(즉, 데이터가 변경되었는데 저장이 되지 않은 상태이면 저장한다.)

 ---------------------------------------------------

 실행예시)
 -------------------------------
 다음 메뉴를 선택하세요
 1. 전화번호 등록
 2. 전화번호 수정
 3. 전화번호 삭제
 4. 전화번호 검색
 5. 전화번호 전체 출력
 0. 프로그램 종료
 -------------------------------
 번호입력 >> 1

 새롭게 등록할 전화번호 정보를 입력하세요.
 이름 >> 홍길동
 전화번호 >> 010-1234-1234
 주소 >> 대전 중구 대흥동

 "홍길동 " 전화번호 등록 완료

 -------------------------------
 다음 메뉴를 선택하세요
 1. 전화번호 등록
 2. 전화번호 수정
 3. 전화번호 삭제
 4. 전화번호 검색
 5. 전화번호 전체 출력
 0. 프로그램 종료
 ------------------------------------
 번호입력 >> 1

 새롭게 등록할 전화번호 정보를 입력하세요.
 이름 >> 홍길동

 '홍길동'은 이미 등록된 사람입니다.

 ------------------------------------
 다음 메뉴를 선택하세요
 1. 전화번호 등록
 2. 전화번호 수정
 3. 전화번호 삭제
 4. 전화번호 검색
 5. 전화번호 전체 출력
 0. 프로그램 종료
 ------------------------------------
 번호입력 >> 5

 ---------------------------------------------
 번호 이름 전화번호 주소
 ----------------------------------------------
 1 홍길동 010-1234-1234 대전 중구 대흥동

 ----------------------------------------------
 출력완료... */

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.basic.ScanUtill;

public class D_PhoneBookTest {
	Map<String, Phone> infor = new HashMap<>();
	private static int count = 0;
	
public static void main(String[] args) {

		D_PhoneBookTest p = new D_PhoneBookTest();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new DataInputStream(
							new FileInputStream("D:/D_Other/PhoneData.dat")
							) );
			
			//읽어온 객체를 저장할 변수
			Object obj;
			
			System.out.println("저장된 전화번호 목록을 가져오는중...");
			
			while((obj=ois.readObject())!= null){
				Phone phone = (Phone)obj;
				
				//초기화를 해준다. 맵에 저장하기위해 get으로 가져온것을 변수에 저장
				phone = new Phone(phone.getName(), phone.getNum(), phone.getAddr());
			
				//map에 저장 
				p.infor.put(phone.getName(), phone);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		while (true) {
			System.out.println("----------------------------");
			System.out.println(" \t전화번호 관리  프로그램");
			System.out.println("-----------------------------");
			System.out.println(" 다음 메뉴를 선택하세요");
			System.out.println(" 1.전화번호 등록");
			System.out.println(" 2. 전화번호 수정");
			System.out.println(" 3. 전화번호 삭제 ");
			System.out.println(" 4. 전화번호 검색");
			System.out.println(" 5. 전화번호 전체 출력");
			System.out.println(" 6. 전화번호 저장");
			System.out.println(" 0. 프로그램 종료");
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("번호 입력 >> ");

			int input = ScanUtill.nextInt();
			switch (input) {
			case 1:
				p.register();
				break;

			case 2:
				p.modify();
				break;

			case 3:
				p.delete();
				break;
			
			 case 4:
			 p.search();
			 break;
			
			 case 5:
			 p.phoneList();
			 break;
			 
			 case 6:
			p.phonSave();
			break;

			case 0:
				if(count!=0) {
					System.out.println("변경사항을 저장하겠습니다.");
					p.phonSave();
				}
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}


	//전화번호를 파일로 저장하는 메서드 
	private void phonSave() {
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/phoneData.dat");
			DataOutputStream dos = new DataOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(dos);
			
			System.out.println("전화번호 저장파일 만드는 중~~~");
			for(String key : infor.keySet()) {
				
			 	//키의 값을 폰 클래스에 넣어서 데이터를 파일로 만들기 
				Phone p = infor.get(key);
				oos.writeObject(p);
			}
			
			System.out.println("저장작업 끝!!! ");
			
			oos.close();
			
//			//저장된 객체를 읽어와 그 내용을 화면에 출력하기
//			
//			ObjectInputStream ois = new ObjectInputStream(
//					new DataInputStream(
//							new FileInputStream("d:/D_Other/phoneData.dat")
//							) );
//			Object obj;	// 읽어온 객체를 저장할 변수
//			
//			try {
//				
//				System.out.println("저장된 전화번호 파일 읽어오기 ....");
//				
//				while((obj = ois.readObject()) != null) {
//					
//					Phone p = (Phone)obj;
//					System.out.println(p.getName());
//					System.out.println(p.getNum());
//					System.out.println(p.getAddr());
//					
//				}
//			}catch (EOFException e) {
//					System.out.println("객체 읽기 작업 끝...");
//					
//				} catch (ClassNotFoundException e) {	//클래스의 존재여부에 대한 예외처리 
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}finally {
//					ois.close();		//스트림 닫기 
//				}
	}catch (IOException e) {
			return;
		}
	
	}




	// 전화번호를 등록하는 메서드

	private void register() {
		// HashMap<String, D_Phone> list;
		//
		String name = null;
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		while(infor.containsKey(name)==false) {
		System.out.print("이름 >>");
		name = ScanUtill.nextLine();
		if (infor.containsKey(name)) {
			System.out.println("같은 이름이 있습니다.");
//			return;
		}else {
		System.out.print("전화번호 >>");
		int num = ScanUtill.nextInt();
		System.out.print("주소>>");
		String addr = ScanUtill.nextLine();
		infor.put(name, new Phone(name, num, addr));
		System.out.println(name + "의 전화번호 등록 완료!");
		count++;
		break;
		}
		}
		for(String p : infor.keySet()) {
			if(p==name) 
			System.out.println(p + " 의 정보  " + infor.get(name)+" 가 저장되었습니다." );
		}

	}

	// 전화번호를 수정하는 메서드
	private void modify() {

		System.out.println("수정할 이름을 입력하세요.");
		String name = ScanUtill.nextLine();
		if (infor.containsKey(name)) {
			System.out.print("수정할 전화번호 >>");
			int num = ScanUtill.nextInt();

			System.out.print("주소>>");
			String addr = ScanUtill.nextLine();
			infor.put(name, new Phone(name, num, addr));
			count++;
		}
		System.out.println(name + "수정 완료!");
		
		
		for(String p : infor.keySet()) {
			if(p==name)
		System.out.println(p + " 의 정보가 " + infor.get(name) + "수정되었습니다.");
		}
	}

	// 전화번호를 삭제하는 메서드
	private void delete() {
		System.out.println("삭제할 이름을 입력하세요.");
		System.out.println("입력>");
		String removeName = ScanUtill.nextLine();
		if(!infor.containsKey(removeName)) {
			System.out.println("저장된 이름이 없습니다.");
			return;
		}
		infor.remove(removeName);
		count++;
		System.out.println(removeName + "삭제완료");
	}
	

	//전화번호를 검색하는 메서드 
	private void search() {
		System.out.println("검색할 이름을 입력해주세요.");
		System.out.println("입력");
		String searchName = ScanUtill.nextLine();
		if(infor.containsKey(searchName)) {
		for(String key : infor.keySet()){
				
		System.out.println(key + " 의 정보는 : " + infor.get(searchName) );

				
			}
		}
	
	}
	
	//전화번호를 전체 출력하는 메서드
	private void phoneList() {
	
	System.out.println("전체 전화번호부 목록 ");
	for(String key : infor.keySet()) {
		System.out.println("==================================");
		System.out.println("이름             전화번호                   주소 ");
		System.out.println("-----------------------------");
		System.out.println(key + " : " + infor.get(key));
		System.out.println("-----------------------------");
		System.out.println("==================================");
		
	}
	
		
	}

	
	
	
}

class Phone implements Serializable{
	private String name;
	private int num;
	private String addr;
	
	
	public Phone(String name, int num, String addr) {
		super();
		this.name = name;
		this.num = num;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "\t번호: " + num + "\t주소 :" + addr;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
