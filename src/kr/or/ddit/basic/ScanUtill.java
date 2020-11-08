package kr.or.ddit.basic;

import java.util.Scanner;

public class ScanUtill {
	
	
	

	private static Scanner scan = new Scanner(System.in);
	
	public static String nextLine() {
		return scan.nextLine();
		
	}
	
	public static Integer nextInt() {
	
	return Integer.parseInt(scan.nextLine());
	}
	
}
