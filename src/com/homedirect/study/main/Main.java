package com.homedirect.study.main;

import com.homedirect.study.model.Account;
import com.homedirect.study.services.AccountService;
import com.homedirect.study.services.HistoryService;
import com.homedirect.study.services.PaymentService;
import com.homedirect.study.services.impl.AccountServiceImpl;
import com.homedirect.study.services.impl.HistoryServiceImpl;
import com.homedirect.study.services.impl.MenuServiceImpl;
import com.homedirect.study.services.impl.PaymentServiceImpl;
import com.homedirect.study.storage.AccountStorage;
import com.homedirect.study.storage.TransactionStorage;
import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.commom.AccountMenuConstant.*;
import static com.homedirect.study.commom.RootMenuConstants.*;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		AccountService accountService = new AccountServiceImpl();
		PaymentService paymentService = new PaymentServiceImpl();
		HistoryService historyService = new HistoryServiceImpl();
		AccountStorage accountStorage = new AccountStorage();
		boolean flag = true;

		do {
			MenuServiceImpl.showMenu();
			String choose = ScanUtils.enterString();
			switch (choose) {
			case CREATE:
				String username = accountService.getUsername();
				if (accountService.notEmpty(username)) {
					
					String password = accountService.inputPassword();
					if (accountService.notEmpty(password)) {
						
						accountService.create(username, password);
						System.out.println(" \n Create Account Successfully! \n");
						break;
					}
					
					return;
				}
				
				System.out.println("You make too many Mistakes!End Program! \n");
				return;
			case SIGN_IN:
				Account account = accountService.signIn(accountService.inputUsername(), accountService.inputPassword());
				
				if(account == null) {
					System.out.println("\n Invalid Username or Password! \n");
					break;
				}
				
				System.out.println("\n Sign In Successfully \n");
				boolean flg;
				do {
					
					MenuServiceImpl.showOption();
					flg = true;
					choose = ScanUtils.enterString();

					switch (choose) {
					case DEPOSIT:
						paymentService.deposit(account, accountService.inputAmount());
						break;

					case WITHDRAWAL:
						paymentService.withdraw(account, accountService.inputAmount());
						break;

					case TRANSFER:
						System.out.println("\n Please enter the recipient's account ID: \n");
						Account toAccount = accountService.getAccountById(accountService.inputAccountId());
						if (toAccount == null || toAccount.getAccountId() == account.getAccountId()) {
							System.out.println(" \n Account does not exist or Invalid! \n");
							break;
						}

						paymentService.transfer(account, toAccount, accountService.inputAmount());
						break;

					case HISTORY:
						historyService.showHistory(account);
						break;

					case CHANGE_PASSWORD:
						accountService.changePassword(accountService.inputOldPassword(),
								accountService.inputNewPassword(), account);
						break;

					case INFORMATION:
						accountService.showInformation(account);
						break;

					case EXIT:
						System.out.println("\n See you later! \n");
						flg = false;
					}
					
//					TransactionStorage.writerFileAccount(accountService.getAccounts());

				} while (flg);
			
				break;

			case END_PROGRAM:
				System.out.println("\n End program! \n");
				flag = false;
			}
		} while (flag);
	}
}