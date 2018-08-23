package com.homedirect.study.validator;

import static com.homedirect.study.commom.ConfigConstant.*;

public class AccountValidator {

	public boolean isValidUsernamePassword(String value) {
		return isEmpty(value) || LENGTH_FROM > value.length() || value.length() > LENGTH_TO;
	}
		
	public boolean isValidAmount(double amount) {
		if (amount <= 0 && amount % 10000 != 0) {
			System.out.println("\n the amount must be greater than 0! \n");
			return false;
		}
		return true;
	}

	private boolean isEmpty(String value) {
		return (value == null || value.isEmpty());
	}
}