package com.homedirect.study.services.impl;

import java.util.Date;

import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;
import com.homedirect.study.model.Transaction.TransactionType;
import com.homedirect.study.services.HistoryService;
import com.homedirect.study.storage.TransactionStorage;
import com.homedirect.study.util.DateUtils;

import static com.homedirect.study.commom.ConfigConstant.*;

public class HistoryServiceImplSuper implements HistoryService {

	@Override
	public Transaction saveTransaction(byte transactionType, long fromAccountId, long toAccountId, double amount, double fee, byte type, String status) {
		Transaction transaction = new Transaction();
		
		transaction.setType(transactionType);
//		transaction.setFromAccount(fromAccountId);
//		transaction.setToAccount(toAccountId);
		transaction.setAmount(amount);
		transaction.setType(type);
		transaction.setFee(fee);
//		transaction.setRequestDatetime(DateUtils.convertDateToString(new Date(),DDMMYYYY));
//		transaction.setStatus(status);
//		TransactionStorage.writerOneTransaction(transaction);

//		return TransactionStorage.addTransaction(transaction);
		return null;
	}

	protected void historyDeposit(Account account) {
//		for (int i = 0; i < TransactionStorage.sizeTransaction(); i++) {
//			Transaction transaction = TransactionStorage.getTransaction(i);
//			if (conditionPrintHistory(transaction, TransactionType.DEPOSIT, account)) {
//				System.out.println(transaction.printDeposit());
//			}
//		}
	}

	protected void historyWithdraw(Account account) {
//		for (int i = 0; i < TransactionStorage.sizeTransaction(); i++) {
//			Transaction transaction = TransactionStorage.getTransaction(i);
//			if (conditionPrintHistory(transaction, TransactionType.WITHDRAW, account))
//				System.out.println(transaction.printWithdraw());
//		}
	}

	protected void historyTransfer(Account account) {
//		for (int i = 0; i < TransactionStorage.sizeTransaction(); i++) {
//			Transaction transaction = TransactionStorage.getTransaction(i);
//			if (conditionPrintHistory(transaction, TransactionType.TRANSFER, account)) {
//				System.out.println(transaction.printTransfer());
//			}
//		}
	}

	protected void historyReceive(Account account) {
//		for (int i = 0; i < TransactionStorage.sizeTransaction(); i++) {
//			Transaction transaction = TransactionStorage.getTransaction(i);
//			if (conditionPrintHistoryReceive(transaction, TransactionType.TRANSFER, account)) {
//				System.out.println(transaction.printReceive());
//			}
//		}
	}

	public boolean conditionPrintHistory(Transaction transaction, byte type, Account account) {
		return (transaction.getType() == type && account.getAccountId() == (transaction.getFromAccount()));
	}

	private boolean conditionPrintHistoryReceive(Transaction transaction, byte type, Account account) {
		return (transaction.getType() == type && transaction.getFromAccount() != account.getAccountId()
				&& transaction.getToAccount() == (account.getAccountId()));
	}

	@Override
	public void showHistory(Account account) {
	}
}
