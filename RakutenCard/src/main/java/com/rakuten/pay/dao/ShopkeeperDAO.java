package com.rakuten.pay.dao;

import java.util.List;
import com.rakuten.pay.Banks.ShopkeeperBankAccount;


public interface ShopkeeperDAO {

	void save_customer(ShopkeeperBankAccount shopkeeper);
	void delete_shopkeeper(int shop_id);
	ShopkeeperBankAccount find_shopkeeper(int shop_id);
	List<ShopkeeperBankAccount> find_all_shops();
	void addAmount(int shop_id, double amount);
	double checkBalance(int shop_id);
	
}
