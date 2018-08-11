package com.homedirect.study.service;

import com.homedirect.study.model.Account;

public interface PaymentService {

	void withdraw(Account account, double amount);

	void transfer(Account fromAccount, Account toAccount, double amount);

	void deposit(Account account, double amount);

	void showHistory(Account account);


}

