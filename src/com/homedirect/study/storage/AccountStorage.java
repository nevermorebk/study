package com.homedirect.study.storage;

import com.homedirect.study.model.Account;

import java.util.List;

import static com.homedirect.study.commom.ConfigConstant.ACCOUNT_SOURCE;

public class AccountStorage extends AbstractStorage<Account>{

	private static List<Account> accounts;

	public AccountStorage() {
		accounts = readDataSource(ACCOUNT_SOURCE);
	}

	public static void add(Account account) {
		accounts.add(account);
	}

	public static int size() {
		return accounts.size();
	}

	public static Account findById(int id) {
		return accounts.stream().filter(acc -> acc.getAccountId() == id).findFirst().orElse(null);
	}

	public static Account findByUsernameAndPassword(String username, String password) {
		return accounts.stream().filter(acc -> acc.getUsername().equals(username) && acc.getPassword().equals(password)).findFirst().orElse(null);
	}

	public static Account findByUsername(String username) {
		return accounts.stream().filter(acc -> acc.getUsername().equals(username)).findFirst().orElse(null);
	}


}
