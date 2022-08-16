package com.doranco;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class Account implements Serializable{
	
	
	private String accountId;
	
	
	private double amount;
	

	private Date date=new Date();
	
	public Account() {

	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", amount=" + amount + ", date=" + date + "]";
	}
	
	
	

}
