package com.homedirect.study.model;

import com.homedirect.study.util.DateUtils;
import com.homedirect.study.util.NumberUtils;

import static com.homedirect.study.common.ConfigConstant.DDMMYYYY;

import java.util.Date;

public class Transaction {

	private int fromaccount;
	private int toAccount;
	private byte type;
	private double amount;
	private double fee;
	private Date requestDatetime;

	public static class TransactionType {
		public static byte DEPOSIT = 1; 
		public static byte WITHDRAW = 2; 
		public static byte TRANSFER = 3; 
	}
	
	public int getFromAccount() {
		return fromaccount;
	}

	public void setFromAccount(int account) {
		this.fromaccount = account;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
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

	public String printDeposit() {
		return "Transaction type: Deposit " + " Date: " + DateUtils.convertDateToString(requestDatetime, DDMMYYYY)
				+ "    Amount: +" + NumberUtils.formatAmount(amount) + "    Fee: " + NumberUtils.formatAmount(fee)
				+ "\n";
	}

	public String printWithdraw() {
		return "Transaction Type: Withdraw " + " Date: " + DateUtils.convertDateToString(requestDatetime, DDMMYYYY)
				+ "    Amount: -" + NumberUtils.formatAmount(amount) + "    Fee: " + NumberUtils.formatAmount(fee)
				+ "\n";
	}

	public String printTransfer() {
		return "Transaction Type: Transfer " + " Date: " + DateUtils.convertDateToString(requestDatetime, DDMMYYYY) + "    Amount: -"
				+ NumberUtils.formatAmount(amount) + "    Fee: " + NumberUtils.formatAmount(fee) + "\n";
	}

	public String printReceive() {
		return "Transaction Type: Receive " + " Date: " + DateUtils.convertDateToString(requestDatetime, DDMMYYYY) + "  Account Transfer: " + fromaccount + "    Amount: +"
				+ NumberUtils.formatAmount(amount) + "    Fee: " + NumberUtils.formatAmount(fee) + "\n";
	}
}
