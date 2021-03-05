package com.rakuten.pay.service;

import java.util.List;

import com.rakuten.pay.Banks.CustomerBankAccount;

public interface CustomerBankService {
	
	void createUser(CustomerBankAccount customer);
	void deleteUser(int id);
	void addAmount(int cust_id, double amount);
	double checkBalance(int id);
	List<CustomerBankAccount> findAll();
}
