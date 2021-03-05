package com.rakuten.pay.dao;

import java.util.List;

import com.rakuten.pay.Banks.CustomerBankAccount;

public interface CustomerDAO {
	
	void save_customer(CustomerBankAccount customer);
	void delete_customer(int cust_id);
	CustomerBankAccount find_customer(int cust_id);
	List<CustomerBankAccount> find_all_customers();
	void addAmount(int cust_id, double amount);
	double checkBalance(int cust_id);

}
