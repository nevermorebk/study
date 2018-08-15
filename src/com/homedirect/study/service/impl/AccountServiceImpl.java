package com.homedirect.study.service.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.service.AccountService;
import com.homedirect.study.util.NumberUtils;
import com.homedirect.study.util.ScanUtils;
import com.homedirect.study.validator.AccountValidator;
import static com.homedirect.study.common.ConfigConstant.*;

import static com.homedirect.study.common.ConfigConstant.DEFAULT_AMOUNT;

import com.homedirect.study.common.CustomList;

public class AccountServiceImpl extends AbstracService implements AccountService {

	private CustomList<Account> accounts = new CustomList<>();
	private AccountValidator accountValidator = new AccountValidator();

	@Override
	public void create(String username, String password) {
		Account account = new Account();
		account.setAccountId(NumberUtils.generateAccountId());
		account.setUsername(username);
		account.setPassword(password);
		account.setAmount(DEFAULT_AMOUNT);
		accounts.add(account);
	}

	@Override
	public Account signIn(String username, String password) {
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
				return account;
			}
		}

		return null;
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
	public String getUsername(int count) {

		String username;
		if (count >= NUMBER) {
			System.out.println(" \n You entered too many wrong! \n");
			return null;
		}
		System.out.println(" \n Input username: \n");
		username = ScanUtils.getScanner();
		if (!accountValidator.isValidUsername(username) || !getAccountByUsername(username)) {
			return getUsername(++count);
		}

		return username;
	}

	@Override
	public String createUsername(int count) {

		String username;
		if (count >= NUMBER) {
			System.out.println(" \n You entered too many wrong! \n");
			return null;
		}
		System.out.println(" \n Input username: \n");
		username = ScanUtils.getScanner();
		if (!accountValidator.isValidUsername(username)) {
			return getUsername(++count);
		}

		return username;
	}

	@Override
	public String createPassword(int count) {
		String password;
		if (count >= NUMBER) {
			System.out.println(" \n You entered too many wrong! \n");
			return null;
		}
		System.out.println(" \n Input password: \n");
		password = ScanUtils.getScanner();
		if (!accountValidator.isValidPassword(password)) {
			return createPassword(++count);
		}
		
		return password;
	}

	@Override
	public String createOldPassword(int count) {
		String password;
		if (count >= NUMBER) {
			System.out.println(" \n You entered too many wrong! \n");
			return null;
		}
		System.out.println(" \n Input Old Password: ");
		password = ScanUtils.getScanner();
		if (!accountValidator.isValidPassword(password)) {
			return createPassword(++count);
		}
		
		return password;
	}

	@Override
	public String createNewPassword(int count) {
		String password;
		if (count >= NUMBER) {
			System.out.println("You entered too many wrong! \n");
			return null;
		}
		System.out.println(" \n Input New Password: \n");
		password = ScanUtils.getScanner();
		if (!accountValidator.isValidPassword(password)) {
			return createPassword(++count);
		}
		
		return password;
	}

	@Override
	public Account getAccountById(int accountId) {
		for (int i = 0; i < accounts.size(); i++) {
			Account accountToFind = accounts.get(i);
			if (accountToFind.getAccountId() == accountId) {
				return accountToFind;
			}
		}

		return null;
	}

	@Override
	public double createAmount() {
		double amount = 0;
		do {
			System.out.print("\n Please enter amount: \n");
			try {
				amount = Double.valueOf(ScanUtils.getScanner());
			} catch (NumberFormatException e) {
			}

		} while (!accountValidator.isValidAmount(amount));

		return amount;
	}

	@Override
	public int getAccountId() {
		do {
			try {
				Integer value = Integer.valueOf(ScanUtils.getScanner());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("\n Invalid account ID! try again! \n");
			}

		} while (true);
	}

	@Override
	public void showInformation(Account account) {
		System.out.println(account.toString());
	}

	public boolean getAccountByUsername(String username) {
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (username.equals(account.getUsername())) {
				System.out.println(" \n Username already exists! \n");
				return false;
			}
		}
		
		return true;
	}
}
