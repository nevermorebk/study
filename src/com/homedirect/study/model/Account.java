package com.homedirect.study.model;

import com.homedirect.study.util.NumberUtils;

public class Account {

	private int accountId;
	private String username;
	private String password;
	private double amount;

	@Override
	public String toString() {
		return  "	  ============ Information Account ============== \n" + 
	" Account Id = " + accountId + "  |  Username = " + username + "  |  Balance = " + NumberUtils.formatAmount(amount) + "$" + "\n";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
