package com.homedirect.study.util;

import java.util.Scanner;

public class ScanUtils {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String enterString() {
		return scanner.nextLine();
	}
	
	public static Integer enterId() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static String enterUsername() {
		System.out.println(" \n Please enter Username: ");
		return scanner.nextLine();
	}
	
	public static String enterPassword() {
		System.out.println(" \n Please enter Password: ");
		return scanner.nextLine();
	}
	
	public static String enterNewPassword() {
		System.out.println(" \n Please enter New Password: ");
		return scanner.nextLine();
	}
	
	public static String enterOldPassword() {
		System.out.println(" \n Please enter Old Password: ");
		return scanner.nextLine();
	}
	
	public static Integer enterAmount() {
		System.out.println(" \n Please enter Amount: ");
		return Integer.parseInt(scanner.nextLine());
	}
}