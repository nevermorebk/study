package com.homedirect.study.services.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.services.AccountService;
import com.homedirect.study.storage.AccountStorage;
import com.homedirect.study.util.NumberUtils;
import com.homedirect.study.util.ScanUtils;
import com.homedirect.study.validator.AccountValidator;

import static com.homedirect.study.commom.ConfigConstant.DEFAULT_AMOUNT;
import static com.homedirect.study.commom.ConfigConstant.NUMBER_ERROR;

public class AccountServiceImpl extends AbstracService implements AccountService {

	private AccountValidator accountValidator = new AccountValidator();
	int count = 0;

	@Override
	public void create(String username, String password) {
		Account account = new Account();
		account.setAccountId(NumberUtils.generateAccountId());
		account.setUsername(username);
		account.setPassword(password);
		account.setAmount(DEFAULT_AMOUNT);
		AccountStorage.add(account);
	}

	@Override
	public Account signIn(String username, String password) {
		return AccountStorage.findByUsernameAndPassword(username, password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, Account account) {
		if (!isValidateChangePassword(oldPassword, account)) {
			System.out.println(" \n You have entered the wrong old password! \n");
			return;
		}

		if (!confirm()) {
			System.out.println(" \n Password change failed! \n");
			return;
		}

		account.setPassword(newPassword);
		System.out.println(" \n Change password successfully! \n");
	}

	private boolean isValidateChangePassword(String oldPassword, Account account) {
		return oldPassword.equals(account.getPassword());
	}

	
	@Override
	public String getUsername() {
		String username;
		
		if (count == NUMBER_ERROR) {
			return null;
		}
		
		username = ScanUtils.enterUsername();
		if (accountValidator.isValidUsernamePassword(username) || AccountStorage.findByUsername(username) == null) {
			System.out.println("Username must have be between 3 to 15 characters or Username already exists!");
			count++;
			return getUsername();
		}

		return username;
	}

	@Override
	public String inputUsername() {
		String username;
		if (count == NUMBER_ERROR) {
			return null;
		}
		
		username = ScanUtils.enterUsername();
		if (accountValidator.isValidUsernamePassword(username)) {
			System.out.println("Username must have be between 3 to 15 characters!");
			count++;
			return inputUsername();
		}

		return username;
	}

	@Override
	public String inputPassword() {
		String password;
		if (count == NUMBER_ERROR) {
			return null;
		}
		
		password = ScanUtils.enterPassword();
		if (accountValidator.isValidUsernamePassword(password)) {
			System.out.println("Password must have be between 3 to 15 characters!");
			count++;
			return inputPassword();
		}
		
		return password;
	}

	@Override
	public String inputOldPassword() {
		String password;
		if (count == NUMBER_ERROR) {
			return null;
		}
		
		password = ScanUtils.enterOldPassword();
		if (accountValidator.isValidUsernamePassword(password)) {
			System.out.println("Password must have be between 3 to 15 characters!");
			count++;
			return inputOldPassword();
		}
		
		return password;
	}

	@Override
	public String inputNewPassword() {
		String password;
		if (count == NUMBER_ERROR) {
			return null;
		}
		
		password = ScanUtils.enterNewPassword();
		if (accountValidator.isValidUsernamePassword(password)) {
			System.out.println("Password must have be between 3 to 15 characters!");
			count++;
			return inputNewPassword();
		}
		
		return password;
	}

	@Override
	public Account getAccountById(int accountId) {
		return AccountStorage.findById(accountId);
	}

	@Override
	public double inputAmount() {
		double amount = 0;
		do {
			try {
				amount = ScanUtils.enterAmount();
			} catch (NumberFormatException e) {
				System.out.println("Please enter Number!");
			}

		} while (!accountValidator.isValidAmount(amount));

		return amount;
	}

	@Override
	public int inputAccountId() {
		do {
			try {
				return ScanUtils.enterId();
			} catch (NumberFormatException e) {
				System.out.println("\n Invalid account ID! try again! \n");
			}

		} while (true);
	}
	
	public boolean notEmpty(String value) {
		return (value != null && !value.equals(""));
	}

	@Override
	public void showInformation(Account account) {
		System.out.println(account.toString());
	}

}
