package com.homedirect.study.service.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.service.AccountService;
import com.homedirect.study.support.CustomList;
import com.homedirect.study.util.NumberUtils;
import com.homedirect.study.util.ScanUtils;
import com.homedirect.study.validator.AccountValidator;

import static com.homedirect.study.common.ConfigConstant.DEFAULT_AMOUNT;

public class AccountServiceImpl extends AbstracService implements AccountService {

    private CustomList<Account> accounts = new CustomList<>();
    private AccountValidator accountValidator = new AccountValidator();
    
    @Override
    public void create(String username, String password) {
        Account account = new Account();
        account.setAccountId(NumberUtils.generateAccountId());
        account.setUsername((username));
        account.setPassword(password);
        account.setAmount(DEFAULT_AMOUNT);
        accounts.add(account);
    }

    @Override
    public Account signIn(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword, Account account) {
        if (!isValidateChangePassword(oldPassword,account)) {
            return;
        }

        if (confirm()) {
            return;
        }

        account.setPassword(newPassword);

        System.out.println("Change password successfully! \n");
    }



    private boolean isValidateChangePassword(String oldPassword, Account account) {
        return account.getPassword().equals(oldPassword);
    }

    public String createUsername() {
        String username;
        do {
            username = getUsername();
        } while (getAccountByUsername(username) != null);
        return username;
    }

    public String getUsername() {
        String username;
        do {
            System.out.print("\n Please enter username: ");
            username = ScanUtils.getScanner();
        } while (!accountValidator.isValidUsername(username));
        return username;
    }

    public String createPassword() {
        String password;
        do {
            System.out.print("\n Please enter password: ");
            password = ScanUtils.getScanner();
        } while (!accountValidator.isValidPassword(password));
        return password;
    }

    public String createNewPassword() {
        String password;
        do {
            System.out.print("\n Please enter new password: ");
            password = ScanUtils.getScanner();
        } while (!accountValidator.isValidPassword(password));
        return password;
    }

    @Override
    public Account getAccountById(int accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account accountToFind = accounts.get(i);
            if (accountToFind.getAccountId() == accountId) {
                return accountToFind;
            }
        }

        return null;
    }


    public double createAmount() {
        double amount = 0 ;
        boolean flg = true;
        do {
            System.out.print("\n Please enter amount: \n");
            try {
                amount = Double.valueOf(ScanUtils.getScanner());
            } catch (Exception e) {
                System.out.println("\n Invalid amount!: \n");
                flg = false;
            }
        } while (flg && !accountValidator.isValidAmount(amount));
        return amount;
    }

    @Override
    public int getAccountId() {
        do {
            try {
                Integer value = Integer.valueOf(ScanUtils.getScanner());
                return value;
            } catch (Exception e) {
                System.out.println("\n Invalid account id!: \n");
            }
        } while (true);
    }

    @Override
    public void showInformation(Account account) {
        System.out.println(account.toString());
    }

    public Account getAccountByUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (username.equals(acc.getUsername())) {
                return acc;
            }
        }
        return null;
    }
}
