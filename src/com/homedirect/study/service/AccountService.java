package com.homedirect.study.service;

import com.homedirect.study.model.Account;
import com.homedirect.study.support.CustomList;

public interface AccountService {

    void create(String username, String password);

    Account signIn(String username, String password);

    void changePassword(String oldPassword, String newPassword, Account account);

    String getUsername();

    String createUsername();

    String createPassword();

    double createAmount();

    int getAccountId();

    void showInformation(Account account);

    Account getAccountById(int accountId);

    String createNewPassword();

}
