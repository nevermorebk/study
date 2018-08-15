package com.homedirect.study.service.impl;

import com.homedirect.study.common.CustomList;
import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;
import com.homedirect.study.model.Transaction.TransactionType;
import com.homedirect.study.service.TransactionService;
import com.homedirect.study.service.MenuService;
import com.homedirect.study.util.ScanUtils;
import static com.homedirect.study.common.HistoryMenuConstants.*;

import java.util.Date;

public class TransactionServiceImpl implements TransactionService {

	private CustomList<Transaction> transactions = new CustomList<>();

	@Override
	public void createTransaction(int fromAccountId, Integer toAccountId, double amount, double fee, byte type) {
		Transaction transaction = new Transaction();
		transaction.setFromAccount(fromAccountId);
		transaction.setToAccount(toAccountId);
		transaction.setAmount(amount);
		transaction.setType(type);
		transaction.setFee(fee);
		transaction.setRequestDatetime(new Date());
		transactions.add(transaction);
	}

	@Override
	public void showHistory(Account account) {
		for (int i = 0; i < transactions.size(); i++) {
			boolean flag = true;
			do {
				MenuService.transactionMenu();
				int choose = Integer.parseInt(ScanUtils.getScanner());
				switch (choose) {

				case HISTORY_DEPOSIT:
					historyDeposit(account);
					break;

				case HISTORY_WITHDRAW:
					historyWithdraw(account);
					break;

				case HISTORY_TRANSFER:
					historyTransfer(account);
					break;

				case HISTORY_RECEIVE:
					historyReceive(account);
					break;

				default:
					historyDeposit(account);
					historyWithdraw(account);
					historyTransfer(account);
					historyReceive(account);
					break;

				case HISTORY_EXIT:
					System.out.println("Bye!");
					flag = false;
				}
			} while (flag);
		}
	}

	private void historyDeposit(Account account) {
		for (int i = 0; i < transactions.size(); i++) {
			Transaction transaction = transactions.get(i);
			if (transaction.getType() == TransactionType.DEPOSIT) {
				if (account.getAccountId() == transaction.getFromAccount()) {
					System.out.println(transaction.printDeposit());
				}
			}
		}
	}

	private static void historyWithdraw(Account account) {
		for (int i = 0; i < transactionList.size(); i++) {
			Transaction transaction = transactionList.get(i);
			if (transaction.getType() == TransactionType.WITHDRAW) {
				if (account.getAccountId() == transaction.getFromAccount()) {
					System.out.println(transaction.printWithdraw());
				}
			}
		}
	}

	private static void historyTransfer(Account account) {
		for (int i = 0; i < transactionList.size(); i++) {
			Transaction transaction = transactionList.get(i);
			if (transaction.getType() == TransactionType.TRANSFER) {
				if (account.getAccountId() == transaction.getFromAccount()) {
					System.out.println(transaction.printTransfer());
				}
			}
		}
	}
	
	private static void historyReceive(Account account) {
		for (int i = 0; i < transactionList.size(); i++) {
			Transaction transaction = transactionList.get(i);
			if (transaction.getType() == TransactionType.TRANSFER) {
				if (account.getAccountId() == transaction.getFromAccount() && account.getAccountId() == transaction.getToAccount()) {
					System.out.println(transaction.printReceive());
				}
			}
		}
	}
}
