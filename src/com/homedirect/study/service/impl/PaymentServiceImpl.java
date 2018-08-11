package com.homedirect.study.service.impl;

import com.homedirect.study.model.Account;
import com.homedirect.study.model.Transaction;
import com.homedirect.study.model.enums.TransactionType;
import com.homedirect.study.service.PaymentService;
import com.homedirect.study.support.CustomList;
import com.homedirect.study.util.DateUtils;

import java.util.Date;

import static com.homedirect.study.common.ConfigConstant.*;

public class PaymentServiceImpl extends AbstracService implements PaymentService {

    private CustomList<Transaction> transactions = new CustomList<>();

    @Override
    public void deposit(Account account, double amount) {
        if (confirm()) {
            account.setAmount(account.getAmount() + amount);
            Transaction transaction = createDepositWithdrawalTransaction(account.getAccountId(), amount, 0,  TransactionType.DEPOSIT);
            transactions.add(transaction);
            System.out.println("Deposit successfully! \n");
        }
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (isValidAmount(account, amount)) {
            System.out.println("Invalid amount!");
            return;
        }

        if (confirm()) {
            account.setAmount(account.getAmount() - (amount + FEE));
            Transaction transaction = createDepositWithdrawalTransaction(account.getAccountId(), amount, FEE, TransactionType.WITHDRAWAL);
            transactions.add(transaction);
            System.out.println("Withdrawal successfully! \n");
        }
    }


    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if (isValidAmount(fromAccount, amount)) {
            System.out.println("Invalid amount!");
            return;
        }

        if (confirm()) {
            toAccount.setAmount(toAccount.getAmount() + amount);
            fromAccount.setAmount(fromAccount.getAmount() - (amount + FEE));
            Transaction transaction = createTransferTransaction(fromAccount.getAccountId(), toAccount.getAccountId(), amount, FEE);
            transactions.add(transaction);
            System.out.println("Transfer successfully! \n");
        }
    }

    @Override
    public void showHistory(Account account) {
        CustomList<Transaction> transactionList = new CustomList<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.getAccount() == account.getAccountId() || (transaction.getToAccount() == account.getAccountId() && TransactionType.TRANSFER == transaction.getType())) {
                transactionList.add(transaction);
            }
        }

        System.out.println("======== Payment History ==========");
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            switch (transaction.getType()) {
                case DEPOSIT:
                    System.out.println("Request Time: " + DateUtils.convertDateToString(transaction.getRequestDatetime(), DDMMYYYY) + "    Amount: +" + transaction.getAmount() + "    Fee: " + transaction.getFee()); break;
                case WITHDRAWAL:
                    System.out.println("Request Time: " + DateUtils.convertDateToString(transaction.getRequestDatetime(), DDMMYYYY) + "    Amount: -" + transaction.getAmount() + "    Fee: " + transaction.getFee()); break;
                case TRANSFER:
                    if (transaction.getAccount() == account.getAccountId()) {
                        System.out.println("Request Time: " + DateUtils.convertDateToString(transaction.getRequestDatetime(), DDMMYYYY) + "    Amount: -" + transaction.getAmount() + "    Fee: " + transaction.getFee());
                    } else {
                        System.out.println("Request Time: " + DateUtils.convertDateToString(transaction.getRequestDatetime(), DDMMYYYY) + "    Amount: +" + transaction.getAmount() + "    Fee: " + transaction.getFee());
                    }
                    break;

            }
        }
    }



    private boolean isValidAmount(Account account, double amount) {
        return account.getAmount() - DEFAULT_AMOUNT < amount + FEE;
    }

    private Transaction createDepositWithdrawalTransaction(int accountId, double amount, double fee, TransactionType type) {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountId);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setFee(fee);
        transaction.setRequestDatetime(new Date());
        return transaction;
    }

    private Transaction createTransferTransaction(int fromAccountId, int toAccount, double amount, double fee) {
        Transaction transaction = new Transaction();
        transaction.setAccount(fromAccountId);
        transaction.setToAccount(toAccount);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.TRANSFER);
        transaction.setFee(fee);
        transaction.setRequestDatetime(new Date());
        return transaction;
    }
}
