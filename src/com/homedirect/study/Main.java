package com.homedirect.study;

import com.homedirect.study.common.RootMenuConstants;
import com.homedirect.study.model.Account;
import com.homedirect.study.service.AccountService;
import com.homedirect.study.service.ShowMenu;
import com.homedirect.study.service.impl.AccountServiceImpl;
import com.homedirect.study.service.impl.PaymentServiceImpl;
import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.common.AccountMenuConstant.*;
import static com.homedirect.study.common.AccountMenuConstant.EXIT;
import static com.homedirect.study.common.RootMenuConstants.*;

public class Main {

	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		boolean flag = true;
		do {
			ShowMenu.showMenu();
			String choose = ScanUtils.getScanner();
			switch (choose) {
			case CREATE:
				String username = accountService.createUsername();
				String password = accountService.createPassword();
				accountService.create(username, password);
				System.out.println("Create Account Successfully! \n");
				break;
			case SIGNIN:
				Account account = accountService.signIn(accountService.getUsername(), accountService.createPassword());
				if (account != null) {
					System.out.println("Sign In Successfully \n");
					boolean flg;
					do {
						ShowMenu.showOption();
						flg = true;
						choose = ScanUtils.getScanner();
						
						switch (choose) {
							case DEPOSIT:
								paymentService.deposit(account, accountService.createAmount());
								break;
								
							case WITHDRAWAL:
								paymentService.withdraw(account, accountService.createAmount());
								break;
								
							case TRANSFER:
								Account toAccount = accountService.getAccountById(accountService.getAccountId());
								if (toAccount == null || toAccount.getAccountId() == account.getAccountId()) {
									System.out.println("Invalid account!");
									break;
								}
								paymentService.transfer(account, toAccount, accountService.createAmount());
								break;

							case HISTORY:
								paymentService.showHistory(account);
								break;
								
							case CHANGE_PASSWORD:
								accountService.changePassword(accountService.createPassword(), accountService.createNewPassword(), account);
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
			case RootMenuConstants.EXIT:
				System.out.println("End program!");
				flag = false;
			}
		} while (flag);
	}
}