package com.homedirect.study.util;

import java.text.DecimalFormat;

import com.homedirect.study.model.Account;
import com.homedirect.study.storage.TransactionStorage;

public class NumberUtils {

	private static DecimalFormat decimalFormat;

	private static int accountId = 0;

	public static int generateAccountId() {
		return ++accountId ;
	}

	public static void initAccountId(int accountId) {
		NumberUtils.accountId = accountId;
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
