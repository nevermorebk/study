package com.homedirect.study.service;

import com.homedirect.study.model.Account;

public interface TransactionService {

	void showHistory(Account account);
	
	void createTransaction(int fromAccountId, Integer toAccountId, double amount, double fee, byte type);
}
