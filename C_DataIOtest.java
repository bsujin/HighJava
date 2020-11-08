package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C_DataIOtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_other/test.data");
			
			//자료형 단위를 출력 할 보조스트림 객체 (DataOutputStream)  생성
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200);   	 	//정수형으로 출력 
			dos.writeFloat(123.45f); 	//실수형(float)으로 출력 
			dos.writeBoolean(false);  	// 논리형으로 출력
			dos.writeUTF("ABcd123가나"); // 문자열 형식으로 출력
			
			System.out.println(" 출력 완료 ");
			
			//---------------------------
			//출력한 자료 읽어오기
			
			FileInputStream fin = new FileInputStream("d:/D_Other/test.data");
			DataInputStream din = new DataInputStream(fin);
			
			//DataInputStream으로 데이터를 읽을 때는 출력할 때의 순서와 같은 순서로 읽어와야 된다.
			System.out.println("정수형 : " + din.readInt());
			System.out.println("실수형 : " + din.readFloat());
			System.out.println("논리형 : " + din.readBoolean());
			System.out.println("문자열 : " + din.readUTF());
		
			din.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
