package com.homedirect.study.util;

import com.homedirect.study.validator.AccountValidator;

import java.util.Scanner;

public class ScanUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static String getScanner() {
		return scanner.nextLine();
	}



/*
	public static String inputOldPassword() {
		String password;
		do {
			System.out.print("\n Please enter old password: \n");
			password = getScanner();
		} while (!AccountValidator.isValidPassword(password));
		return password;
	}

	public static String inputNewPassword() {
		String password;
		do {
			System.out.print("\n Please enter New password: \n");
			password = getScanner();
		} while (!AccountValidator.isValidPassword(password));
		return password;
	}*/
}