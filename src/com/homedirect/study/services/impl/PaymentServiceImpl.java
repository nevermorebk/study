package com.homedirect.study.services.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction.TransactionType;
import com.homedirect.study.services.HistoryService;
import com.homedirect.study.services.PaymentService;

import static com.homedirect.study.commom.ConfigConstant.*;
import static com.homedirect.study.model.Transaction.Status.*;

public class PaymentServiceImpl extends AbstracService implements PaymentService {

	HistoryService history = new HistoryServiceImpl();
	
	@Override
	public void deposit(Account account, double amount) {
		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
//			history.saveTransaction(TransactionType.DEPOSIT, account.getAccountId(), 0, amount,
//					NO_FEE, TransactionType.DEPOSIT, FAILURE);
			
			return;
		}
		
		account.setAmount(account.getAmount() + amount);
		System.out.println(" \n Deposit successfully! \n");
//		history.saveTransaction(TransactionType.DEPOSIT, account.getAccountId(), 0, amount,
//				NO_FEE, TransactionType.DEPOSIT, StatusType.SUCCESS);
	}

	@Override
	public void withdraw(Account account, double amount) {
		if (isValidAmount(account, amount)) {
			System.out.println(" \n Not enough balance! \n");
//			history.saveTransaction(TransactionType.WITHDRAW, account.getAccountId(), 0, amount,
//					FEE, TransactionType.DEPOSIT, StatusType.FAILURE);
			
			return;
		}

		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
//			history.saveTransaction(TransactionType.WITHDRAW, account.getAccountId(), 0, amount,
//					FEE, TransactionType.WITHDRAW, StatusType.FAILURE);
			
			return;
		}
		
		account.setAmount(account.getAmount() - (amount + FEE));
		
		System.out.println(" \n Withdrawal successfully! \n");
//		history.saveTransaction(TransactionType.WITHDRAW, account.getAccountId(), 0, amount, FEE,
//				TransactionType.WITHDRAW, StatusType.SUCCESS);
		
	}

	@Override
	public void transfer(Account fromAccount, Account toAccount, double amount) {
		if (isValidAmount(fromAccount, amount)) {
			System.out.println(" \n Not enough balance! \n");
//			history.saveTransaction(TransactionType.TRANSFER, fromAccount.getAccountId(), toAccount.getAccountId(), amount,
//					FEE, TransactionType.TRANSFER, StatusType.FAILURE);
			
			return;
		}

		if (!confirm()) {
			System.out.println(" \n Transactions fail! \n");
//			history.saveTransaction(TransactionType.TRANSFER, fromAccount.getAccountId(), toAccount.getAccountId(), amount,
//					FEE, TransactionType.TRANSFER, StatusType.FAILURE);
			
			return;
		}

		toAccount.setAmount(toAccount.getAmount() + amount);
		fromAccount.setAmount(fromAccount.getAmount() - (amount + FEE));
		
		System.out.println(" \n Transfer successfully! \n");
//		history.saveTransaction(TransactionType.TRANSFER, fromAccount.getAccountId(), toAccount.getAccountId(), amount,
//				FEE, TransactionType.TRANSFER, StatusType.SUCCESS);
		
	}

	private boolean isValidAmount(Account account, double amount) {
		return (account.getAmount() - DEFAULT_AMOUNT) < amount;
	}
}
