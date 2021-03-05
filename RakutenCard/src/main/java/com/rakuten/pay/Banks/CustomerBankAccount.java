package com.rakuten.pay.Banks;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Customers")
public class CustomerBankAccount implements Serializable{
	
	@Id
	private int cust_account_id;
	
	private String name;
	
	private int mob_number;
	
	private double account_balance;

	public int getCust_account_id() {
		return cust_account_id;
	}

	public void setCust_account_id(int cust_account_id) {
		this.cust_account_id = cust_account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMob_number() {
		return mob_number;
	}

	public void setMob_number(int mob_number) {
		this.mob_number = mob_number;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	public CustomerBankAccount(int cust_account_id, String name, int mob_number, double account_balance) {
		super();
		this.cust_account_id = cust_account_id;
		this.name = name;
		this.mob_number = mob_number;
		this.account_balance = account_balance;
	}

	public CustomerBankAccount() {
		super();
	}
	
	
	

}
