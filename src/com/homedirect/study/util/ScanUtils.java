package com.homedirect.study.util;

import java.util.Scanner;

public class ScanUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static String getScanner() {
		return scanner.nextLine();
	}
}