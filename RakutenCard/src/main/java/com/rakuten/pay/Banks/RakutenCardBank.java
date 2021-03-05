package com.rakuten.pay.Banks;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Rcard")
public class RakutenCardBank implements Serializable{
	
	@Id
	static private int card_id=0;

	private double balance;
	
	private String status;
	
	private int cust_id;
	
	private int shop_id;

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	

	public RakutenCardBank(double balance, String status, int cust_id, int shop_id) {
		super();
		this.card_id++;
		this.balance = balance;
		this.status = status;
		this.cust_id = cust_id;
		this.shop_id = shop_id;
	}

	public RakutenCardBank() {
		super();
	}
	
	

	}
	
