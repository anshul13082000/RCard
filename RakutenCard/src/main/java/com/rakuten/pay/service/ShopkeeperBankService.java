package com.rakuten.pay.service;

import java.util.List;

import com.rakuten.pay.Banks.ShopkeeperBankAccount;

public interface ShopkeeperBankService {

	void createUser(ShopkeeperBankAccount shopkeeper);
	void deleteUser(int id);
	void addAmount(int shop_id, double amount);
	double checkBalance(int id);
	List<ShopkeeperBankAccount> findAll();
	
}
