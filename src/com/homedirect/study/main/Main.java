package com.homedirect.study.main;

import com.homedirect.study.common.Result;
import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;
import com.homedirect.study.service.AccountService;
import com.homedirect.study.service.TransactionService;
import com.homedirect.study.service.MenuService;
import com.homedirect.study.service.PaymentService;
import com.homedirect.study.service.impl.AccountServiceImpl;
import com.homedirect.study.service.impl.TransactionServiceImpl;
import com.homedirect.study.service.impl.PaymentServiceImpl;
import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.common.AccountMenuConstant.*;
import static com.homedirect.study.common.AccountMenuConstant.EXIT;
import static com.homedirect.study.common.Result.SUCCESS;
import static com.homedirect.study.common.RootMenuConstants.*;
import static com.homedirect.study.common.ConfigConstant.*;

public class Main {

	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();
		PaymentService paymentService = new PaymentServiceImpl();
		TransactionService transactionService = new TransactionServiceImpl();
		boolean flag = true;
		
		do {
			MenuService.showMenu();
			String choose = ScanUtils.getScanner();
			switch (choose) {
			case CREATE:
				String username = accountService.getUsername(COUNT);
				if(username != null && !username.equals("")) {
					String password = accountService.createPassword(COUNT);
					if (password != null && !username.equals("")) {
						accountService.create(username, password);
						System.out.println(" \n Create Account Successfully! \n");
						break;
					}
					
					return;
				}
				System.out.println("End Program!");
				return;
			case SIGNIN:
				Account account = accountService.signIn(accountService.createUsername(COUNT), accountService.createPassword(COUNT));
				if (account != null) {
					System.out.println("Sign In Successfully \n");
					boolean flg;
					do {
						MenuService.showOption();
						flg = true;
						choose = ScanUtils.getScanner();

						switch (choose) {
						case DEPOSIT:
							double amountDeposit = accountService.createAmount();
							int result = paymentService.deposit(account, amountDeposit);
							if (result == SUCCESS) {
								transactionService.createTransaction(account.getAccountId(), null, amountDeposit, NUMBER, Transaction.TransactionType.DEPOSIT);
							}

							break;

						case WITHDRAWAL:
							paymentService.withdraw(account, accountService.createAmount());
							break;

						case TRANSFER:
							System.out.println("Please enter the recipient's account ID: ");
							Account toAccount = accountService.getAccountById(accountService.getAccountId());
							if (toAccount == null || toAccount.getAccountId() == account.getAccountId()) {
								System.out.println(" \n Account does not exist or Invalid! \n");
								break;
								
							}
							paymentService.transfer(account, toAccount, accountService.createAmount());
							break;

						case HISTORY:
							System.out.println("pick");
							transactionService.showHistory(account);
							break;

						case CHANGE_PASSWORD:
							accountService.changePassword(accountService.createOldPassword(COUNT),
									accountService.createNewPassword(COUNT), account);
							break;

						case INFORMATION:
							accountService.showInformation(account);
							break;

						case EXIT:
							System.out.println("See you later!");
							flg = false;
						}
					} while (flg);
					break;
					
				} else {
					System.out.println("Invalid Username or Password!");
					break;
				}

			case END_PROGRAM:
				System.out.println("End program!");
				flag = false;
			}
		} while (flag);
	}
}