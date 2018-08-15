package com.homedirect.study.validator;

import static com.homedirect.study.common.ConfigConstant.LENGTH;

public class AccountValidator {

	public boolean isValidUsername(String username) {
		if (isEmpty(username)) {
			System.out.println("\n Please input Username! \n");
			return false;
		} else if (username.length() > LENGTH) {
			System.out.println("\n Username must be less than 15 characters. Please input again! \n");
			return false;
		}
		return true;
	}

	public boolean isValidPassword(String password) {
		if (isEmpty(password)) {
			System.out.println("\n Please input Password! \n");
			return false;
		} else if (password.length() > LENGTH) {
			System.out.println("\n Password must be less than 15 characters. Please input again! \n");
			return false;
		}
		return true;
	}

	public boolean isValidAmount(double amount) {
		if (amount <= 0) {
			System.out.println("\n the amount must be greater than 0! \n");
			return false;
		}
		return true;
	}

	private boolean isEmpty(String value) {
		return (value == null || value.isEmpty());
	}
}