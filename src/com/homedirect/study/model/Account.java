package com.homedirect.study.model;


import com.homedirect.study.util.NumberUtils;

public class Account {

	private int accountId;
	private String username;
	private String password;
	private double amount;
	
	public Account() {
	}

	public Account(int accountId, String username, String password, double amount) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return  "	  ============ Information Account ============== \n" + 
" Account Id = " + accountId + "\t" + " Username = " + username + "\t" + " Balance = " + NumberUtils.formatAmount(amount) + " VND" + "\n";
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

	public String toJSONString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"accountId\":" + getAccountId() + "," );
		buffer.append("\"username\":\"" + getUsername() + "\"," );
		buffer.append("\"password\":\"" + getPassword() + "\"," );
		buffer.append("\"amount\":" + getAmount());
		buffer.append("}");
		
		return buffer.toString();
	}
}
