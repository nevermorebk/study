package com.homedirect.study.model;

import com.homedirect.study.model.enums.TransactionType;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {

    private int account;
    private int toAccount;
    private TransactionType type;
    private double amount;
    private double fee;
    private Date requestDatetime;

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", toAccount=" + toAccount +
                ", type=" + type +
                ", amount=" + amount +
                ", fee=" + fee +
                ", requestDatetime=" + requestDatetime +
                '}';
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Date getRequestDatetime() {
        return requestDatetime;
    }

    public void setRequestDatetime(Date requestDatetime) {
        this.requestDatetime = requestDatetime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
