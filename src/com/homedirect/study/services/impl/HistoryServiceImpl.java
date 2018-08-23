package com.homedirect.study.services.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction.TransactionType;
import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.commom.ConfigConstant.*;

public class HistoryServiceImpl extends HistoryServiceImplSuper {
	
	@Override
	public void showHistory(Account account) {

		boolean flag = true;
		do {
			try {
				MenuServiceImpl.transactionMenu();
				int choose = Integer.parseInt(ScanUtils.enterString());
				switch (choose) {
					case TransactionType.DEPOSIT:
						historyDeposit(account);
						break;
	
					case TransactionType.WITHDRAW:
						historyWithdraw(account);
						break;
	
					case TransactionType.TRANSFER:
						historyTransfer(account);
						break;
	
					case TransactionType.RECEIVE:
						historyReceive(account);
						break;
	
					default:
						historyDeposit(account);
						historyWithdraw(account);
						historyTransfer(account);
						historyReceive(account);
						break;
	
					case EXIT_HISTORY:
						System.out.println(" \n Bye History! \n");
						flag = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter Number!");
			}
		} while (flag);
	}
}
