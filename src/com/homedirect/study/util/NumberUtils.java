package com.homedirect.study.util;

import java.text.DecimalFormat;

public class NumberUtils {

	private static DecimalFormat decimalFormat;
	private static int count = 1;

	public static int generateAccountId() {
		return count++;
	}

	private static String numberFormat(String pattern, double value) {
		decimalFormat = new DecimalFormat(pattern);
		String outputAmount = decimalFormat.format(value);
		return outputAmount;
	}

	public static String formatAmount(double amount) {
		String pattern = "###,###,###";
		return numberFormat(pattern, amount);
	}
}
