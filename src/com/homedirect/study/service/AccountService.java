package com.homedirect.study.service;

import com.homedirect.study.model.Account;

public interface AccountService {

	void create(String username, String password);

	Account signIn(String username, String password);

	void changePassword(String oldPassword, String newPassword, Account account);

	String getUsername(int count);
	
	String createUsername(int count);

	String createPassword(int count);

	String createOldPassword(int count);

	String createNewPassword(int count);

	double createAmount();

	int getAccountId();

	void showInformation(Account account);

	Account getAccountById(int accountId);
}
