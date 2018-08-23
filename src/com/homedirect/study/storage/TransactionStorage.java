package com.homedirect.study.storage;

import com.homedirect.study.model.Transaction;

import java.util.List;

import static com.homedirect.study.commom.ConfigConstant.TRANSACTION_HISTORY_SOURCE;

public class TransactionStorage extends AbstractStorage<Transaction> {

    private static List<Transaction> transactions;

    public TransactionStorage() {
        transactions = readDataSource(TRANSACTION_HISTORY_SOURCE);
    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


}
