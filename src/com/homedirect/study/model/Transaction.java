package com.homedirect.study.model;


import com.homedirect.study.util.NumberUtils;

import java.util.Date;

public class Transaction {

	private int fromAccount;
	private int toAccount;
	private byte type;
	private double amount;
	private double fee;
	private Date requestDatetime;
	private byte status;

	public class Status {
		public static final byte SUCCESS = 1;
		public static final byte FAILURE = -1;
	}
	
	public class TransactionType {
		public static final byte DEPOSIT = 1;
		public static final byte WITHDRAW = 2;
		public static final byte TRANSFER = 3;
		public static final byte RECEIVE = 4;
	}

	public Transaction() {
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
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

	public Date getRequestDatetime() {
		return requestDatetime;
	}

	public void setRequestDatetime(Date requestDatetime) {
		this.requestDatetime = requestDatetime;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String toJSONString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{ ");
		buffer.append("\"type\":" + getType() + ",");
		buffer.append("\"fromAccount\":" + getFromAccount() + ",");
		buffer.append("\"toAccount\":" + getToAccount() + ",");
		buffer.append("\"requestDateTime\":\"" + getRequestDatetime() + "\",");
		buffer.append("\"amount\":" + getAmount()+ ",");
		buffer.append("\"fee\":" + getFee() + ",");
		buffer.append("\"status\":\"" + getStatus() + "\"");
		buffer.append(" }");

		return buffer.toString();
	}

	public String printDeposit() {
		return "Transaction type:  Deposit " + "   Date: " + requestDatetime + "    Amount: +"
				+ NumberUtils.formatAmount(amount) + " VND " + "   Status: " + status + "\n";
	}

	public String printWithdraw() {
		return "Transaction Type:  Withdraw " + "  Date: " + requestDatetime + "    Amount: -"
				+ NumberUtils.formatAmount(amount) + " VND " + "    Fee: " + NumberUtils.formatAmount(fee) + " VND "
				+ "   Status: " + status + " \n";
	}

	public String printTransfer() {
		return "Transaction Type:  Transaction " + "  Date: " + requestDatetime + "    Amount: -"
				+ NumberUtils.formatAmount(amount) + " VND " + "    Fee: " + NumberUtils.formatAmount(fee) + " VND "
				+ "   Status: " + status + "\n";
	}

	public String printReceive() {
		return "Transaction Type:  Receive " + "	from Account ID: " + fromAccount + "   Date: " + requestDatetime
				+ "   Amount: +" + NumberUtils.formatAmount(amount) + " VND " + "   Status: " + status + "\n";
	}
}
