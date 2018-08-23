package com.homedirect.study.services;

import com.homedirect.study.model.Account;

public interface AccountService {

	void create(String username, String password);

	Account signIn(String username, String password);

	void changePassword(String oldPassword, String newPassword, Account account);

	String getUsername();
	
	String inputUsername();

	String inputPassword();

	String inputOldPassword();

	String inputNewPassword();

	double inputAmount();

	int inputAccountId();

	void showInformation(Account account);

	Account getAccountById(int accountId);

	boolean notEmpty(String username);
	
}
