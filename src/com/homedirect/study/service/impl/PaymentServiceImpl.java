package com.homedirect.study.service.impl;

import com.homedirect.study.common.Result;
import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;
import com.homedirect.study.model.Transaction.TransactionType;
import com.homedirect.study.service.PaymentService;

import static com.homedirect.study.common.ConfigConstant.*;
import static com.homedirect.study.common.Result.VALIDATION;

import com.homedirect.study.common.CustomList;

public class PaymentServiceImpl extends AbstracService implements PaymentService {
	
	CustomList<Transaction> transactions = new CustomList<>();

	@Override
	public int deposit(Account account, double amount) {
		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
			return Result.VALIDATION;
		}
		account.setAmount(account.getAmount() + amount);
		System.out.println(" \n Deposit successfully! \n");
		return Result.SUCCESS;
	}

	@Override
	public void withdraw(Account account, double amount) {
		if (isValidAmount(account, amount)) {
			System.out.println(" \n Not enough balance! \n");
			return;
		}

		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
			return;
		}
		account.setAmount(account.getAmount() - (amount + FEE));
		history.createTransaction(account.getAccountId(), TO_ACCOUNT, amount, FEE, TransactionType.WITHDRAW);
		
		System.out.println(" \n Withdrawal successfully! \n");
	}

	@Override
	public void transfer(Account fromAccount, Account toAccount, double amount) {
		if (isValidAmount(fromAccount, amount)) {
			System.out.println(" \n Not enough balance! \n");
			return;
		}

		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
			return;
		}

		toAccount.setAmount(toAccount.getAmount() + amount);
		fromAccount.setAmount(fromAccount.getAmount() - (amount + FEE));
		history.createTransaction(fromAccount.getAccountId(), toAccount.getAccountId(), amount, FEE, TransactionType.TRANSFER);;

		System.out.println(" \n Transfer successfully! \n");
	}

	private boolean isValidAmount(Account account, double amount) {
		return (account.getAmount() - DEFAULT_AMOUNT) < amount;
	}
}
