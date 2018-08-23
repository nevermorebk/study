package com.homedirect.study.services;

import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;

public interface HistoryService {

	void showHistory(Account account);
	
	Transaction saveTransaction(byte typeTransaction, long fromAccountId, long toAccountId, double amount, double fee, byte type, String status);
}
